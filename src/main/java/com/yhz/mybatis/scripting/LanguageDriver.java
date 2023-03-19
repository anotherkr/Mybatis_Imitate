package com.yhz.mybatis.scripting;

import com.yhz.mybatis.executor.resultset.ParameterHandler;
import com.yhz.mybatis.mapping.BoundSql;
import com.yhz.mybatis.mapping.MappedStatement;
import com.yhz.mybatis.mapping.SqlSource;
import com.yhz.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * 脚本语言驱动
 * @author yanhuanzhan
 * @date 2023/3/15 - 17:49
 */
public interface LanguageDriver {
    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);
    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
