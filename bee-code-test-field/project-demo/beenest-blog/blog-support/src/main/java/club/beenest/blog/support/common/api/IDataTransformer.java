/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.api;

/**
 * 数据转换器接口
 *
 * @param <T> 传入的数据类型
 * @param <R> 返回的数据类型
 */
public interface IDataTransformer <R,T> {
    /**
     * 执行数据转换
     * @param data 需要进行转换的数据
     * @return 转换完成的数据
     */
   R transform(T data);
}
