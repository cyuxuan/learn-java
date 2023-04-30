/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.request;

/**
 * http状态
 *
 * @author 陈玉轩
 * @since 1.0
 */
public interface HttpCode {
    /**
     * 请求成功状态码
     */
    int HTTP_CODE_SUCCESS = 200;

    /**
     * 非法请求
     */
    int HTTP_CODE_ILLEGAL_REQUEST = 400;

    /**
     * 无权限状态码
     */
    int HTTP_CODE_NO_AUTH = 403;

    /**
     * 服务错误
     */
    int HTTP_CODE_SERVER_ERROR = 500;
}
