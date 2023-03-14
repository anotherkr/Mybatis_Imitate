package com.yhz.mybatis.reflection.wrapper;

import com.yhz.mybatis.reflection.MetaObject;

/**
 * 对象包装工厂
 * @author yanhuanzhan
 * @date 2023/3/14 - 14:06
 */
public interface ObjectWrapperFactory {
    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
