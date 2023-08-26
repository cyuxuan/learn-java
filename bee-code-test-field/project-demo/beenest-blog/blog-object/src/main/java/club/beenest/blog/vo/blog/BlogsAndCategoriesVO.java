/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.vo.blog;

import club.beenest.blog.entity.blog.Blog;
import club.beenest.blog.entity.catagory.Category;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 返回给前端当前博客与分类信息
 *
 * @author 陈玉轩
 * @since　1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogsAndCategoriesVO {
    /**
     * 当前分页中的博客信息
     */
    private PageInfo<Blog> blogPageInfo;

    /**
     * 博客类型信息
     */
    private List<Category> categorys;
}
