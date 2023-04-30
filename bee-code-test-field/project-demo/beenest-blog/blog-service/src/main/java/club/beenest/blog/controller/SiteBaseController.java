/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.controller;

import club.beenest.blog.service.bassite.SiteBaseService;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单基本信息
 *
 * @author 陈玉轩
 * @since 1.0
 */
@RestController
public class SiteBaseController {
    @Autowired
    SiteBaseService siteBaseService;

    /**
     * 获取站点配置信息、最新推荐博客、分类列表、标签云、随机博客
     *
     * @return 站点信息
     */
    @GetMapping("siteBas")
    public Result siteBase() {
        // 获取基本的网站信息
        return Result.ok(siteBaseService.siteBase().toString());
    }
}
