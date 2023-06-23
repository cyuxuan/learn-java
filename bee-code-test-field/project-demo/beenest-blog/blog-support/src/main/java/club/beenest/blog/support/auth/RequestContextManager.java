/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.auth;

/**
 * 请求上下文控制器
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class RequestContextManager {
    /**
     * 存储当前上下文数据
     */
    private static final ThreadLocal<RequestContext> context = new ThreadLocal<>();


    /**
     * 创建上下文信息
     *
     * @return RequestContext 上下文数据
     */
    public static RequestContext createContext() {
        if (context.get() == null) {
            RequestContext requestContext = new RequestContext();
            context.set(requestContext);
            return requestContext;
        } else {
            return context.get();
        }
    }

    /**
     * 初始化上下文信息
     *
     * @param requestContext 上下文数据
     */
    public static void init(RequestContext requestContext) {
        context.set(requestContext);
    }

    /**
     * 获取上下文信息
     *
     * @return 上下文数据
     */
    public static RequestContext getRequestContext() {
        return context.get();
    }
}
