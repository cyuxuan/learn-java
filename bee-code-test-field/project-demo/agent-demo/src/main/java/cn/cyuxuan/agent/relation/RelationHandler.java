package cn.cyuxuan.agent.relation;

import cn.cyuxuan.agent.config.AgentConfig;
import cn.cyuxuan.agent.util.ClassUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

/**
 * 关系处理器
 */
public class RelationHandler {
    /**
     * 扫描所有的class
     * 并记录他们之间的关系
     */
    public static void scanClassRelease() throws ClassNotFoundException, IOException {
        // 获取配置文件中的class名称
        List<String> agentEntrances = AgentConfig.getAgentEntrances();
        // 遍历该集合，获取对应的关系
        for(String classItem : agentEntrances) {
            // 处理当前的类型
            handlerRelation(classItem);
        }
        // 完成之后输出集合
        File file = new File("D://applog/relation.txt");
        OutputStreamWriter writer = new FileWriter(file);
        for (String item : ClassRelation.getRelatedClass()) {
            writer.write(item);
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }

    /**
     * 处理对应的关系
     * @param className
     */
    public static void handlerRelation(String className) throws ClassNotFoundException {
        // 获取当前类型
        Class<?> clazz = Class.forName(className);
        // 判断当前类型是否是接口
        List<Class> clazzes;
        if(clazz.isInterface()) {
            // 获取该接口的所有实现类
            clazzes = ClassUtils.getAllInterfaceAchieveClass(clazz);
        } else {
            clazzes = Collections.singletonList(clazz);
        }
        // 遍历实现类集合
        for(Class clazzItem : clazzes) {
            if (ClassRelation.classInRelation(clazzItem.getTypeName())) {
                continue;
            } else {
                // 当前类型加入到关系集合中
                ClassRelation.addRelation(clazzItem.getTypeName());
            }
            // 获取所有的字段
            Field[] fields = clazzItem.getDeclaredFields();
            // 如果当前类型已经加入到关系集合中就不再处理
            // 遍历所有的字段
            for(Field field : fields) {
                // 处理当前类型
                handlerRelation(field.getType().getTypeName());
            }
        }
    }
}
