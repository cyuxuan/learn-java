/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.exception;

/**
 * 数据校验异常
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class ValidationException extends Exception {
    ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
