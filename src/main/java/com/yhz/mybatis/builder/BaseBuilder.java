package com.yhz.mybatis.builder;

import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.type.TypeAliasRegistry;
import com.yhz.mybatis.type.TypeHandlerRegistry;

/**
 * @author yanhuanzhan
 * @date 2023/3/7 - 0:28
 */
public class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;
    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }
}
