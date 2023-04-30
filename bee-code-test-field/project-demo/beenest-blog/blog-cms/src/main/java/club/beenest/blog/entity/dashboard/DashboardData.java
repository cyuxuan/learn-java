/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.entity.dashboard;

import club.beenest.blog.entity.blog.CategoryBlogCount;
import club.beenest.blog.entity.tag.TagBlogCount;
import club.beenest.blog.entity.visit.CityVisitor;
import club.beenest.blog.entity.visit.VisitRecord;

import java.util.List;
import java.util.Map;

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
    List<TagBlogCount> tagBlogCountMap;

    /**
     * 访客记录
     */
    List<VisitRecord> visitRecordList;

    /**
     * 按照城市区分的访客数量
     */
    List<CityVisitor> cityVisitorList;

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public int getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(int blogCount) {
        this.blogCount = blogCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<CategoryBlogCount> getCategoryBlogCountList() {
        return categoryBlogCountList;
    }

    public void setCategoryBlogCountList(List<CategoryBlogCount> categoryBlogCountList) {
        this.categoryBlogCountList = categoryBlogCountList;
    }

    public List<TagBlogCount> getTagBlogCountMap() {
        return tagBlogCountMap;
    }

    public void setTagBlogCountMap(List<TagBlogCount> tagBlogCountMap) {
        this.tagBlogCountMap = tagBlogCountMap;
    }

    public List<VisitRecord> getVisitRecordList() {
        return visitRecordList;
    }

    public void setVisitRecordList(List<VisitRecord> visitRecordList) {
        this.visitRecordList = visitRecordList;
    }

    public List<CityVisitor> getCityVisitorList() {
        return cityVisitorList;
    }

    public void setCityVisitorList(List<CityVisitor> cityVisitorList) {
        this.cityVisitorList = cityVisitorList;
    }

    @Override
    public String toString() {
        return "DashboardData{" +
                "pv=" + pv +
                ", uv=" + uv +
                ", blogCount=" + blogCount +
                ", commentCount=" + commentCount +
                ", categoryBlogCountList=" + categoryBlogCountList +
                ", tagBlogCountMap=" + tagBlogCountMap +
                ", visitRecordList=" + visitRecordList +
                ", cityVisitorList=" + cityVisitorList +
                '}';
    }
}
