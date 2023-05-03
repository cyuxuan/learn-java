package club.beenest.blog.service.dashboard;

import club.beenest.blog.entity.blog.CategoryBlogCount;
import club.beenest.blog.entity.dashboard.DashboardData;
import club.beenest.blog.entity.tag.TagBlogCount;
import club.beenest.blog.entity.visit.CityVisitor;
import club.beenest.blog.entity.visit.VisitRecord;

import java.util.List;

public interface DashboardService {
    int countVisitLogByToday();

    int getBlogCount();

    int getCommentCount();

    List<CategoryBlogCount> getCategoryBlogCountList();

    List<TagBlogCount> getTagBlogCountList();

    List<VisitRecord> getVisitRecordList();

    List<CityVisitor> getCityVisitorList();

    /**
     * 获取面板信息
     *
     * @return 面板信息
     */
    DashboardData dashboard();
}
