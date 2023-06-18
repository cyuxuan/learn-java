package club.beenest.blog.service.category;


import club.beenest.blog.entity.catagory.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分类服务
 *
 * @author 陈玉轩
 * @since 1.0
 */
public interface CategoryService {
    List<Category> getCategoryList();

    PageInfo<Category> getCategoryListForPage(Integer pageNum, Integer pageSize, Category category);

    List<Category> getCategoryNameList();

    void saveCategory(Category category);

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    void deleteCategoryById(Long id);

    void updateCategory(Category category);
}
