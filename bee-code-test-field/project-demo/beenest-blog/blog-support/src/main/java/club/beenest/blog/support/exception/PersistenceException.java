/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.exception;

/**
 * ORM异常
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class PersistenceException extends RuntimeException {
    public PersistenceException() {
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
