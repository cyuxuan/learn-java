/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 对象转换工具
 *
 * @author 陈玉轩
 * @since 1.0
 */
public abstract class ObjectTransformUtils {

    /**
     * 将 list转换为对应的 map
     *
     * @param key  当前对象中需要取出来做key的对象
     * @param list 待转换的List
     * @param <T>  function的输出类型
     * @param <R>  list的类型
     * @return 转换后的Map
     */
    public static <T, R> Map<T, R> listToMap(Function<R, T> key, List<R> list) {
        Map<T, R> map = new HashMap<>(list.size());

        list.stream().forEach(item -> {
            map.put(key.apply(item), item);
        });

        return map;
    }
}
