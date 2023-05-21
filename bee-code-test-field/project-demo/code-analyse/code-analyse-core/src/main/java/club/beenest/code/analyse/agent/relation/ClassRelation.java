/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.agent.relation;

import java.util.HashSet;

/**
 * 类之间的关系
 *
 * @author 陈玉轩
 */
public class ClassRelation {
    /**
     * 存储所有有关系的类
     */
    private static HashSet<String> relatedClass = new HashSet<>();

    /**
     * 添加类进当前的类型集合中
     *
     * @param className 类名称
     */
    public static void addRelation(String className) {
        relatedClass.add(className);
    }

    public static boolean classInRelation(String className) {
        return relatedClass.contains(className);
    }

    public static HashSet<String> getRelatedClass() {
        return relatedClass;
    }

    public static void setRelatedClass(HashSet<String> relatedClass) {
        ClassRelation.relatedClass = relatedClass;
    }
}
