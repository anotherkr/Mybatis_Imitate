package com.yhz.mybatis.reflection.wrapper;

import com.yhz.mybatis.reflection.MetaObject;

/**
 * @author yanhuanzhan
 * @date 2023/3/14 - 14:06
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
