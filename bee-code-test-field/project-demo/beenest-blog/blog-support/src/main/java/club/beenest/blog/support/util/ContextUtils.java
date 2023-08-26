/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 上下文运行环境的的工具类
 *
 * @author 陈玉轩
 * @since　1.0
 */
public abstract class ContextUtils {
    public static long getUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.getAuthentication();
        return 1L;
    }
}
