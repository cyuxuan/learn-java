/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.controller.dashboard.transform;

import club.beenest.blog.entity.blog.CategoryBlogCount;
import club.beenest.blog.entity.dashboard.DashboardData;
import club.beenest.blog.entity.tag.Tag;
import club.beenest.blog.entity.tag.TagBlogCount;
import club.beenest.blog.support.common.api.IDataTransformer;
import club.beenest.blog.vo.category.CategoryNameBlogCountVO;
import club.beenest.blog.vo.dashboard.DashboardDataVO;
import club.beenest.blog.vo.tag.TagBlogCountVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据展示面板数据转换
 *
 * @author 陈玉轩
 * @since　1.0
 */

@Component
public class DashboardDataTransformer implements IDataTransformer<DashboardDataVO, DashboardData> {
    @Override
    public DashboardDataVO transform(DashboardData data) {
        DashboardDataVO dashboardData = new DashboardDataVO();
        dashboardData.setPv(data.getPv());
        dashboardData.setUv(data.getUv());
        dashboardData.setCommentCount(data.getCommentCount());
        dashboardData.setBlogCount(data.getBlogCount());
        dashboardData.setCityVisitorList(data.getCityVisitorList());
        dashboardData.setVisitRecordList(data.getVisitRecordList());
        // 设置分类数据
        // 获取分类的类型名称
        List<String> categoryNames = new ArrayList<>();
        List<CategoryNameBlogCountVO> categoryNameBlogCountList = new ArrayList<>();
        for(CategoryBlogCount item : data.getCategoryBlogCountList()) {
            categoryNames.add(item.getName());
            CategoryNameBlogCountVO categoryNameBlogCount = new CategoryNameBlogCountVO();
            categoryNameBlogCount.setName(item.getName());
            categoryNameBlogCount.setValue(item.getValue());
            categoryNameBlogCountList.add(categoryNameBlogCount);
        }
        dashboardData.setCategoryNames(categoryNames);
        dashboardData.setCategoryNameBlogCountList(categoryNameBlogCountList);
        // 设置标签数据
        List<String> tags = new ArrayList<>();
        List<TagBlogCountVO> tagBlogCountList = new ArrayList<>();
        for(TagBlogCount item : data.getTagBlogCountList()) {
            tags.add(item.getName());
            TagBlogCountVO tagBlogCount = new TagBlogCountVO();
            tagBlogCount.setName(item.getName());
            tagBlogCount.setValue(item.getValue());
            tagBlogCountList.add(tagBlogCount);
        }
        dashboardData.setTags(tags);
        dashboardData.setTagBlogCountList(tagBlogCountList);
        return dashboardData;
    }
}
