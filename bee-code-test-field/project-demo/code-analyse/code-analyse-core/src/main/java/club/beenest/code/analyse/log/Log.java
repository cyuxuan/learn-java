/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.log;

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
