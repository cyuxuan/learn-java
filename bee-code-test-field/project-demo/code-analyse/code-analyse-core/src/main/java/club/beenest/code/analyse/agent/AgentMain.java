/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.code.analyse.agent;

import java.lang.instrument.Instrumentation;

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("动态测试");
    }
}
