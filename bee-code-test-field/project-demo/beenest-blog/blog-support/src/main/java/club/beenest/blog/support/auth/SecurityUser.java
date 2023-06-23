/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 安全的账户信息，不携带账户敏感信息
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUser {
    /**
     * 用户id唯一指定
     */
    long userId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像信息
     */
    private String avatar;

    /**
     * 用户邮件信息
     */
    private String email;

    /**
     * 用户角色信息
     */
    private String role;
}
