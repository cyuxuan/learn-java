/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.service.redis.impl;

/**
 * redis键
 *
 * @author 陈玉轩
 * @since 1.0
 */
public interface RedisKeyConstants {
    /**
     * 首页博客简介列表 分页对象key
     * homeBlogInfoList : {{1,"第一页的缓存"},{2,"第二页的缓存"}}
     */
    String HOME_BLOG_INFO_LIST = "homeBlogInfoList";
    /**
     * 分类名列表key
     */
    String CATEGORY_NAME_LIST = "categoryNameList";
    /**
     * 标签云列表key
     */
    String TAG_CLOUD_LIST = "tagCloudList";
    /**
     * 站点信息key
     */
    String SITE_INFO_MAP = "siteInfoMap";
    /**
     * 最新推荐博客key
     */
    String NEW_BLOG_LIST = "newBlogList";
    /**
     * 关于我页面key
     */
    String ABOUT_INFO_MAP = "aboutInfoMap";
    /**
     * 友链页面信息key
     */
    String FRIEND_INFO_MAP = "friendInfoMap";
    /**
     * 博客归档key
     */
    String ARCHIVE_BLOG_MAP = "archiveBlogMap";
    /**
     * 博客访问量key
     */
    String BLOG_VIEWS_MAP = "blogViewsMap";
    /**
     * 访客标识码key
     */
    String IDENTIFICATION_SET = "identificationSet";
    /**
     * QQ号与对应头像URL key
     */
    String QQ_AVATAR_URL_MAP = "qqAvatarUrlMap";
}
