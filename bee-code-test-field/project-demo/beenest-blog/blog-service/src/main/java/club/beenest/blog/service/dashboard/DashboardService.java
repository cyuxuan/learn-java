package club.beenest.blog.service.dashboard;

import club.beenest.blog.entity.dashboard.DashboardData;

public interface DashboardService {
    /**
     * 获取面板信息
     *
     * @return 面板信息
     */
    DashboardData dashboard();
}
