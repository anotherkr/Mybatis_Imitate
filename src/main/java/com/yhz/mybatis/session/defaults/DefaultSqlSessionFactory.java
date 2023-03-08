package com.yhz.mybatis.session.defaults;

import com.yhz.mybatis.binding.MapperRegistry;
import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.session.SqlSession;
import com.yhz.mybatis.session.SqlSessionFactory;

/**
 * @author yanhuanzhan
 * @date 2023/3/5 - 14:20
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
