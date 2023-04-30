/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.dao;

import club.beenest.blog.entity.NewBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * blog信息查询
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Mapper
@Repository
public interface BlogDao {
    List<NewBlog> getNewBlogListByIsPublished(@Param("limit") int limit);
}
