/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.agent;

import club.beenest.code.analyse.agent.transformer.DefaultTransformer;
import club.beenest.code.analyse.agent.config.AgentConfig;
import club.beenest.code.analyse.agent.relation.RelationHandler;
import javassist.ClassPool;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class AgentPreMain {
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, IOException {
        // 加载配置文件
        AgentConfig.load();
        // 获取当前指定类涉及的所有类信息
        // 启动 socket 链接

        if(AgentConfig.isAgentHandleRelation()) {
            RelationHandler.scanClassRelease();
        } else {
            // 执行 class 文件按转换
            ClassPool pool = new ClassPool(true);
            inst.addTransformer(new DefaultTransformer(pool));
        }
    }
}
