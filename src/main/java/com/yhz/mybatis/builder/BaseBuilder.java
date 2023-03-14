package com.yhz.mybatis.builder;

import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.type.TypeAliasRegistry;

/**
 * @author yanhuanzhan
 * @date 2023/3/7 - 0:28
 */
public class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
