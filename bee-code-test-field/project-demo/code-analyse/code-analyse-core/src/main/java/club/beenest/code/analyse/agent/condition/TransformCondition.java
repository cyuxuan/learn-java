/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.agent.condition;

import club.beenest.code.analyse.agent.config.AgentConfig;

import java.util.List;

public class TransformCondition {
    public static boolean skipTransformClass(String className) {
        // 判断是否在排除集合中
        List<String> agentPackagesExcludes = AgentConfig.getAgentPackagesExcludes();
        // 如果在排除集合中，则需要跳过
        if(agentPackagesExcludes.parallelStream().anyMatch(className::startsWith)) {
            return true;
        }
        // 判断是否在SQL集合中
        List<String> getAgentSqlMethods = AgentConfig.getAgentSqlEntrance();
        if (getAgentSqlMethods.parallelStream().anyMatch(className::equals)) {
            return false;
        }
        // 判断是否在指定包中，如果在则不用跳过
        List<String> agentPackages = AgentConfig.getAgentPackages();
        if (agentPackages.parallelStream().anyMatch(className::startsWith)) {
            // 匹配上包以后还需要进一步匹配入口
            List<String> agentEntrances = AgentConfig.getAgentEntrances();
            if(agentEntrances.size() != 0) {
                // 判断是当前类是否是入口函数
                return agentEntrances.parallelStream().noneMatch(item -> {
                    return item.equals(className);
                });
            } else {
                return false;
            }
        } else {
            // 最终没有匹配上则需要跳过
            return true;
        }
    }
}
