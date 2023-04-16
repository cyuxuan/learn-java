package cn.cyuxuan.code.analysis.log;

import java.util.logging.Logger;

public class Log {
    private static Logger logger = Logger.getLogger("CodeAnalysis");

    /**
     * 记录日志
     *
     * @param msg 日志信息
     */
    public static void log(String msg) {
        // 日志记录
        logger.info(msg);
    }
}
