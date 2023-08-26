/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.vo.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagBlogCountVO {
    /**
     * 标签名
     */
    private String name;
    /**
     * 标签下博客数量
     */
    private Integer value;
}
