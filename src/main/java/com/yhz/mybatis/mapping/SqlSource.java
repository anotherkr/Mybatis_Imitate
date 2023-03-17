package com.yhz.mybatis.mapping;

/**
 * @author yanhuanzhan
 * @date 2023/3/15 - 16:06
 */
public interface SqlSource {
    BoundSql getBoundSql(Object parameterObject);
}
