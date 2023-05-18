/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.controller.dashboard;


import club.beenest.blog.controller.dashboard.transform.DashboardDataTransformer;
import club.beenest.blog.service.dashboard.DashboardService;
import club.beenest.blog.support.request.HttpMessage;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 后台管理仪表盘
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
@RequestMapping("/admin")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    DashboardDataTransformer dashboardDataTransformer;

    @GetMapping("/dashboard")
    public Result dashboard() {
        return Result.ok(HttpMessage.REQUEST_SUCCESS,
                dashboardDataTransformer.transform(dashboardService.dashboard()));
    }

    @Resource(type = DashboardDataTransformer.class)
    public void setDashboardDataTransformer(DashboardDataTransformer dashboardDataTransformer) {
        this.dashboardDataTransformer = dashboardDataTransformer;
    }
}
