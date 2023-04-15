package cn.cyuxuan.code.analysis.agent;

import java.lang.instrument.Instrumentation;

public class AgentDemo {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("动态测试");
    }
}
