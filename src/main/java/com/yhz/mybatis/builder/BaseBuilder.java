package com.yhz.mybatis.builder;

import com.yhz.mybatis.session.Configuration;

/**
 * @author yanhuanzhan
 * @date 2023/3/7 - 0:28
 */
public class BaseBuilder {
    protected final Configuration configuration;
    public BaseBuilder(Configuration configuration) {
        this.configuration=configuration;
    }
    public Configuration getConfiguration() {
        return configuration;
    }

}
