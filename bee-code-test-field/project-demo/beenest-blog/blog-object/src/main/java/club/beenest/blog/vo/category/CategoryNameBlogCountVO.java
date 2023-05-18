/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.vo.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分类名称对应博客数量
 *
 * @author 陈玉轩
 * @since　1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryNameBlogCountVO {
    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类名称对应数量
     */
    private Integer value;
}
