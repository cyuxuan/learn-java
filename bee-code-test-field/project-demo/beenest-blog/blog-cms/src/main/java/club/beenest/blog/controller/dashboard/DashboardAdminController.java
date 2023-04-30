/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.controller.dashboard;

import club.beenest.blog.service.dashboard.DashboardService;
import club.beenest.blog.support.request.HttpMessage;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台管理仪表盘
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
@RequestMapping("/admin")
public class DashboardAdminController {
    @Autowired
    DashboardService dashboardService;

    @GetMapping("/dashboard")
    public Result dashboard() {
        return Result.ok(HttpMessage.REQUEST_SUCCESS, dashboardService.dashboard());
    }
}
