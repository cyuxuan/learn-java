/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.entity.dashboard;

import club.beenest.blog.entity.blog.CategoryBlogCount;
import club.beenest.blog.entity.tag.TagBlogCount;
import club.beenest.blog.entity.visit.CityVisitor;
import club.beenest.blog.entity.visit.VisitRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DashboardData {
    /**
     * 页面访问数量
     */
    int pv;

    /**
     * 用户访问数量
     */
    int uv;

    /**
     * 博客总量
     */
    int blogCount;

    /**
     * 评论总量
     */
    int commentCount;

    /**
     * 分类下的博客数量统计
     */
    List<CategoryBlogCount> categoryBlogCountList;

    /**
     * 标签下的博客数量统计
     */
    List<TagBlogCount> tagBlogCountList;

    /**
     * 访客记录
     */
    List<VisitRecord> visitRecordList;

    /**
     * 按照城市区分的访客数量
     */
    List<CityVisitor> cityVisitorList;
}
