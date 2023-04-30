/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.service.bassite.impl;

import club.beenest.blog.entity.NewBlog;
import club.beenest.blog.entity.SiteBase;
import club.beenest.blog.service.bassite.SiteBaseService;
import club.beenest.blog.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 站点基本信息服务
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class SiteBaseServiceImpl implements SiteBaseService {
    @Autowired
    BlogService blogService;

    @Override
    public SiteBase siteBase() {
        SiteBase siteBase = new SiteBase();
        // 获取最新发布的blog数据
        List<NewBlog> newBlogList = blogService.getNewBlogListByIsPublished();

        return siteBase;
    }
}
