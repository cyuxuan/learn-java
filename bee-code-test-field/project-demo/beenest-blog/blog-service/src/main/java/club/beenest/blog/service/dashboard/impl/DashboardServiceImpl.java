/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.service.dashboard.impl;

import club.beenest.blog.dao.blog.BlogMapper;
import club.beenest.blog.dao.category.CategoryMapper;
import club.beenest.blog.dao.comment.CommentMapper;
import club.beenest.blog.dao.tag.TagMapper;
import club.beenest.blog.dao.visit.CityVisitorMapper;
import club.beenest.blog.dao.visit.VisitRecordMapper;
import club.beenest.blog.entity.blog.CategoryBlogCount;
import club.beenest.blog.entity.catagory.Category;
import club.beenest.blog.entity.dashboard.DashboardData;
import club.beenest.blog.entity.tag.Tag;
import club.beenest.blog.entity.tag.TagBlogCount;
import club.beenest.blog.entity.visit.CityVisitor;
import club.beenest.blog.entity.visit.VisitRecord;
import club.beenest.blog.service.dashboard.DashboardService;
import club.beenest.blog.support.common.dao.log.VisitLogMapper;
import club.beenest.blog.support.util.ObjectTransformUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 仪表盘信息获取
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    VisitLogMapper visitLogMapper;

    @Autowired
    VisitRecordMapper visitRecordMapper;

    @Autowired
    CityVisitorMapper cityVisitorMapper;

    /**
     * 默认查询30天的数据
     */
    private static final int DEFAULT_VISIT_RECORD_LIMIT_NUM = 30;

    @Override
    public int countVisitLogByToday() {
        return visitLogMapper.countVisitLogByToday();
    }

    @Override
    public int getBlogCount() {
        return blogMapper.countBlog();
    }

    @Override
    public int getCommentCount() {
        return commentMapper.countComment();
    }

    @Override
    public List<CategoryBlogCount> getCategoryBlogCountList() {
        // 查询分类id对应的博客数量
        List<CategoryBlogCount> categoryBlogCountList = blogMapper.getCategoryBlogCountList();
        // 查询所有分类的id和名称
        List<Category> categoryList = categoryMapper.getCategoryList();
        // 将分类id与名称转换为map
        Map<Long, Category> categoryMap = ObjectTransformUtils.listToMap(Category::getId, categoryList);
        // 获取分类名称
        for (CategoryBlogCount item : categoryBlogCountList) {
            item.setName(categoryMap.get(item.getId()).getName());
            categoryMap.remove(item.getId());
        }
        // 如果还有剩余的分类则全部为0
        if (categoryMap.size() != 0) {
            for (Map.Entry<Long, Category> entry : categoryMap.entrySet()) {
                CategoryBlogCount categoryBlogCount = new CategoryBlogCount();
                categoryBlogCount.setName(entry.getValue().getName());
                categoryBlogCount.setValue(0);
                categoryBlogCountList.add(categoryBlogCount);
            }
        }
        return categoryBlogCountList;
    }

    @Override
    public List<TagBlogCount> getTagBlogCountList() {
        // 查询标签id对应的博客数量
        List<TagBlogCount> tagBlogCountList = tagMapper.getTagBlogCount();
        // 查询所有标签的id和名称
        List<Tag> tagList = tagMapper.getTagList();
        // 将id与tag名称转换为map
        Map<Long, Tag> tagMap = ObjectTransformUtils.listToMap(Tag::getId, tagList);
        for (TagBlogCount item : tagBlogCountList) {
            item.setName(tagMap.get(item.getId()).getName());
            tagMap.remove(item.getId());
        }
        // 如果还存在tag没使用则是0
        if (tagMap.size() != 0) {
            for (Map.Entry<Long, Tag> entry : tagMap.entrySet()) {
                TagBlogCount tagBlogCount = new TagBlogCount();
                tagBlogCount.setName(entry.getValue().getName());
                tagBlogCount.setValue(0);
                tagBlogCountList.add(tagBlogCount);
            }
        }
        return tagBlogCountList;
    }

    @Override
    public List<VisitRecord> getVisitRecordList() {
        return visitRecordMapper.getVisitRecordListByLimit(DEFAULT_VISIT_RECORD_LIMIT_NUM);
    }

    @Override
    public List<CityVisitor> getCityVisitorList() {
        return cityVisitorMapper.getCityVisitorList();
    }

    @Override
    public DashboardData dashboard() {
        DashboardData dashboardData = new DashboardData();
        dashboardData.setPv(1);
        dashboardData.setUv(1);
        // TODO 获取 pv uv
        // 获取博客总量
        dashboardData.setBlogCount(this.getBlogCount());
        // 获取评论总量
        dashboardData.setCommentCount(this.getCommentCount());
        // 获取分类下的博客总量
        dashboardData.setCategoryBlogCountList(this.getCategoryBlogCountList());
        // 获取 标签下的博客总量
        dashboardData.setTagBlogCountMap(this.getTagBlogCountList());
        // 获取访问记录
        dashboardData.setVisitRecordList(this.getVisitRecordList());
        // 获取按照城市划分的访客数量
        dashboardData.setCityVisitorList(this.getCityVisitorList());
        // 返回面版信息
        return dashboardData;
    }
}
