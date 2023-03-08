package com.yhz.mybatis.session.defaults;

import com.yhz.mybatis.binding.MapperRegistry;
import com.yhz.mybatis.mapping.MappedStatement;
import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.session.SqlSession;

/**
 * @author yanhuanzhan
 * @date 2023/3/5 - 14:20
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
