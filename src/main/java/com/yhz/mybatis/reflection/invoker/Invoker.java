package com.yhz.mybatis.reflection.invoker;

/**
 * 无论任何类型的反射调用，都离不开对象和入参，
 * 只要我们把这两个字段和返回结果定义的通用，就可以包住不同策略的实现类了。
 * @author yanhuanzhan
 * @date 2023/3/14 - 14:04
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}