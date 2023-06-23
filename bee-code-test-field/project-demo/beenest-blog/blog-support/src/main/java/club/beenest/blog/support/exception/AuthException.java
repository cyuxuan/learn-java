/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.exception;

/**
 * 权限校验异常
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class AuthException extends Exception {

    AuthException() {
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
