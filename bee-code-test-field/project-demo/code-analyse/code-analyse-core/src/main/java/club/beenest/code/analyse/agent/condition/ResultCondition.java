/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.agent.condition;

import club.beenest.code.analyse.agent.sourceobject.MethodCommonDescription;
import club.beenest.code.analyse.agent.util.MethodDescriptionUtil;
import club.beenest.code.analyse.agent.config.AgentConfig;

import java.util.List;

public class ResultCondition {
    public static boolean skipPrint(int methodId) {
        List<String> agentEntrances = AgentConfig.getAgentEntrances();
        return agentEntrances.parallelStream().noneMatch(item -> {
            // 获取方法通用描述信息
            MethodCommonDescription methodDescription
                    = MethodDescriptionUtil.getMethodDescription(methodId);
            // 判断字符串中是是否含有#号
            if (item.contains("#")) {
                // 含有井号则是方法级的，执行方法级的跳过判定
                return (methodDescription.getSourceClassName() + "#" + methodDescription.getMethodName()).equals(item);
            } else {
                // 否则为包级的, 执行包级别的跳过判定
                return (methodDescription.getSourceClassName() + "#" + methodDescription.getMethodName()).startsWith(item);
            }
        });
    }
}
