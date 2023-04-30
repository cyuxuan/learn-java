/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.util;

import club.beenest.blog.support.bas.model.dto.UserAgentDTO;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.springframework.stereotype.Component;

/**
 * UserAgent解析工具类
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Component
public class UserAgentUtils {
    private UserAgentAnalyzer uaa;

    public UserAgentUtils() {
        this.uaa = UserAgentAnalyzer
                .newBuilder()
                .useJava8CompatibleCaching()
                .withCache(10000)
                .hideMatcherLoadStats()
                .withField(UserAgent.OPERATING_SYSTEM_NAME_VERSION_MAJOR)
                .withField(UserAgent.AGENT_NAME_VERSION)
                .build();
    }

    /**
     * 从User-Agent解析客户端操作系统和浏览器版本
     *
     * @param userAgent
     * @return
     */
    public UserAgentDTO parseOsAndBrowser(String userAgent) {
        UserAgent agent = uaa.parse(userAgent);
        String os = agent.getValue(UserAgent.OPERATING_SYSTEM_NAME_VERSION_MAJOR);
        String browser = agent.getValue(UserAgent.AGENT_NAME_VERSION);
        return new UserAgentDTO(os, browser);
    }
}
