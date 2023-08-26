/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.auth;

/**
 * 请求上下文
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class RequestContext {
    /**
     * 安全的用户账户信息
     * 不携带账户敏感信息
     */
    SecurityUser securityUser;

    public SecurityUser getSecurityUser() {
        return securityUser;
    }

    public void setSecurityUser(SecurityUser securityUser) {
        this.securityUser = securityUser;
    }
}
