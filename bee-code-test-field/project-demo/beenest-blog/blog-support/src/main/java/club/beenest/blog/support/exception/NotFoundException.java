package club.beenest.blog.support.exception;

/**
 * 数据未找到异常
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
