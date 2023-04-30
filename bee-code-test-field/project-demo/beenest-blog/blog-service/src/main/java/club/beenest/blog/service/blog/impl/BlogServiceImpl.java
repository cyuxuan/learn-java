/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.service.blog.impl;

import club.beenest.blog.dao.BlogDao;
import club.beenest.blog.entity.NewBlog;
import club.beenest.blog.service.blog.BlogService;
import club.beenest.blog.support.bas.constant.CommonConstant;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    BlogDao blogDao;

    @Override
    public List<NewBlog> getNewBlogListByIsPublished() {
        List<NewBlog> newBlogList = blogDao.getNewBlogListByIsPublished(NEW_BLOG_PAGE_SIZE);
        // 判断是否为隐私博客
        for (NewBlog newBlog : newBlogList) {
            if (!CommonConstant.EMPTY_STRING.equals(newBlog.getPassword())) {
                newBlog.setPrivacy(true);
                newBlog.setPassword("");
            } else {
                newBlog.setPrivacy(false);
            }
        }
        return newBlogList;
    }
}
