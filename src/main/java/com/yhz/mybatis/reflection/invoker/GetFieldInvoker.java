package com.yhz.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author yanhuanzhan
 * @date 2023/3/14 - 14:04
 */
public class GetFieldInvoker implements Invoker{
    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
