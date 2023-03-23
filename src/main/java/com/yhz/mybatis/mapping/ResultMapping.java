package com.yhz.mybatis.mapping;

import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.type.JdbcType;
import com.yhz.mybatis.type.TypeHandler;

/**
 * 结果映射
 * @author yanhuanzhan
 * @date 2023/3/19 - 15:36
 */
public class ResultMapping {
    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();
    }
}
