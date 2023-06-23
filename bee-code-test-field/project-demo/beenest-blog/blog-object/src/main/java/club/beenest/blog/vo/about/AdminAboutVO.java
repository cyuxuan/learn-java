/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.vo.about;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理端 【关于我】 页面VO
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Data
@NoArgsConstructor
public class AdminAboutVO {
    /**
     * 是否开启评论
     */
    private boolean commentEnabled;

    /**
     * md文档内容
     */
    private char[] content;

    /**
     * 标题
     */
    private String title;
}
