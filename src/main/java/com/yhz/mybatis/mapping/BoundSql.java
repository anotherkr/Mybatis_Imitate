package com.yhz.mybatis.mapping;

import com.yhz.mybatis.reflection.MetaObject;
import com.yhz.mybatis.session.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanhuanzhan
 * @date 2023/3/8 - 16:07
 */
public class BoundSql {
    private String sql;
    private List<ParameterMapping> parameterMappings;
    /**
     * 表示传递给 SQL 语句的参数对象
     */
    private Object parameterObject;
    /**
     * 一个 Map 类型的变量，表示其他参数的键值对，用于动态生成 SQL 语句
     */
    private Map<String, Object> additionalParameters;
    /**
     * 表示 additionalParameters 的元对象
     */
    private MetaObject metaParameters;

    public BoundSql(Configuration configuration, String sql, List<ParameterMapping> parameterMappings, Object parameterObject) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.parameterObject = parameterObject;
        this.additionalParameters = new HashMap<>();
        this.metaParameters = configuration.newMetaObject(additionalParameters);
    }

    public String getSql() {
        return sql;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public Object getParameterObject() {
        return parameterObject;
    }

    public boolean hasAdditionalParameter(String name) {
        return metaParameters.hasGetter(name);
    }

    public void setAdditionalParameter(String name, Object value) {
        metaParameters.setValue(name, value);
    }

    public Object getAdditionalParameter(String name) {
        return metaParameters.getValue(name);
    }

}
