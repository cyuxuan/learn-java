/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.vo.dashboard;

import club.beenest.blog.entity.visit.CityVisitor;
import club.beenest.blog.entity.visit.VisitRecord;
import club.beenest.blog.vo.category.CategoryNameBlogCountVO;
import club.beenest.blog.vo.tag.TagBlogCountVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 管理端-服务面板的数据返回
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DashboardDataVO {
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
     * 所有分类名称
     */
    List<String> categoryNames;

    /**
     * 类型对应博客数量
     */
    List<CategoryNameBlogCountVO> categoryNameBlogCountList;

    /**
     * 所有的标签名称
     */
    List<String> tags;

    /**
     * 标签对应博客数量
     */
    List<TagBlogCountVO> tagBlogCountList;


    /**
     * 访客记录
     */
    List<VisitRecord> visitRecordList;

    /**
     * 按照城市区分的访客数量
     */
    List<CityVisitor> cityVisitorList;
}
