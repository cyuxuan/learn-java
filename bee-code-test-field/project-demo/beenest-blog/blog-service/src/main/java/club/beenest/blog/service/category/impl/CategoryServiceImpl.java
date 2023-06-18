package club.beenest.blog.service.category.impl;

import club.beenest.blog.dao.category.CategoryMapper;
import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.service.blog.BlogService;
import club.beenest.blog.service.category.CategoryService;
import club.beenest.blog.service.tag.TagService;
import club.beenest.blog.support.basic.service.BasService;
import club.beenest.blog.support.common.service.redis.RedisService;
import club.beenest.blog.support.common.service.redis.impl.RedisKeyConstants;
import club.beenest.blog.support.exception.NotFoundException;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.support.util.StringUtils;
import cn.hutool.core.exceptions.ValidateException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 博客分类业务层实现
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class CategoryServiceImpl extends BasService<Category> implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    TagService tagService;

    @Autowired
    RedisService redisService;

    @Autowired
    BlogService blogService;

    @Override
    public List<Category> getCategoryList() {
        return null;
    }

    @Override
    public PageInfo<Category> getCategoryListForPage(Integer pageNum, Integer pageSize, Category category) {
        return this.selectForPage(pageNum, pageSize, () -> categoryMapper.getCategoryList());
    }

    @Override
    public List<Category> getCategoryNameList() {
        String redisKey = RedisKeyConstants.CATEGORY_NAME_LIST;
        List<Category> categoryListFromRedis = redisService.getListByValue(redisKey);
        if (categoryListFromRedis != null) {
            return categoryListFromRedis;
        }
        List<Category> categoryList = categoryMapper.getCategoryNameList();
        redisService.saveListToValue(redisKey, categoryList);
        return categoryList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveCategory(Category category) {
        // 执行参数校验
        this.checkCategory(category);
        // 执行入库
        if (categoryMapper.saveCategory(category) != 1) {
            throw new PersistenceException("分类添加失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCategory(Category category) {
        // 执行参数校验
        this.checkCategory(category);
        if (categoryMapper.updateCategory(category) != 1) {
            throw new PersistenceException("分类更新失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCategoryById(Long id) {
        // 删除存在博客关联的分类后，该博客的查询会出异常
        int num = blogService.countBlogByCategoryId(id);
        if (num != 0) {
            throw new ValidateException("已有博客与此分类关联，不可删除");
        }
        if (categoryMapper.deleteCategoryById(id) != 1) {
            throw new PersistenceException("删除分类失败");
        }
        redisService.deleteCacheByKey(RedisKeyConstants.CATEGORY_NAME_LIST);
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryMapper.getCategoryById(id);
        if (category == null) {
            throw new NotFoundException("分类不存在");
        }
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryMapper.getCategoryByName(name);
    }

    /**
     * 在执行新增或者修改时检验分类是否存在
     */
    private void checkCategory(Category category) {
        if (StringUtils.isEmpty(category.getName())) {
            throw new ValidateException("分类名称不能为空");
        }
        // 查询分类是否已存在
        Category exitCategory = this.getCategoryByName(category.getName());
        if (exitCategory != null && !exitCategory.getId().equals(category.getId())) {
            // 该分类已经存在则抛出校验异常
            throw new ValidateException("该分类已存在");
        }
    }
}
