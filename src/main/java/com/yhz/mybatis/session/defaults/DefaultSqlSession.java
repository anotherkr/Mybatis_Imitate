package com.yhz.mybatis.session.defaults;

import com.yhz.mybatis.executor.Executor;
import com.yhz.mybatis.mapping.MappedStatement;
import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.session.SqlSession;
import java.util.List;

/**
 * @author yanhuanzhan
 * @date 2023/3/5 - 14:20
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;
    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }
    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getSqlSource().getBoundSql(parameter));
        return list.get(0);
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
