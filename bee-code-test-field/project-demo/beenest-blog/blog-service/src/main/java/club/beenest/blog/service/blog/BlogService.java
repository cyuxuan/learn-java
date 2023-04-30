/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.service.blog;

import club.beenest.blog.entity.NewBlog;

import java.util.List;

public interface BlogService {
    /**
     *
     */
    int NEW_BLOG_PAGE_SIZE = 3;

    List<NewBlog> getNewBlogListByIsPublished();
}
