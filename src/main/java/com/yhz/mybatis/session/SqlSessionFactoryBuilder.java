package com.yhz.mybatis.session;

import com.yhz.mybatis.builder.xml.XMLConfigBuilder;
import com.yhz.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author yanhuanzhan
 * @date 2023/3/7 - 0:30
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
