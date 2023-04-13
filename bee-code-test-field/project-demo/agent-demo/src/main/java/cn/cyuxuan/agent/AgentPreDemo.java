package cn.cyuxuan.agent;

import cn.cyuxuan.agent.config.AgentConfig;
import cn.cyuxuan.agent.relation.RelationHandler;
import cn.cyuxuan.agent.transformer.DefaultTransformer;
import javassist.ClassPool;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class AgentPreDemo {
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, IOException {
        // 加载配置文件
        AgentConfig.load();
        // 获取当前指定类涉及的所有类信息
        if(AgentConfig.isAgentHandleRelation()) {
            RelationHandler.scanClassRelease();
        } else {
            // 执行 class 文件按转换
            ClassPool pool = new ClassPool(true);
            inst.addTransformer(new DefaultTransformer(pool));
        }
    }
}
