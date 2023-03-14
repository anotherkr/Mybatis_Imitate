package com.yhz.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author yanhuanzhan
 * @date 2023/3/14 - 14:05
 */
public class SetFieldInvoker implements Invoker{
    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target, args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
