package com.yhz.mybatis.scripting.xmltags;

import com.yhz.mybatis.executor.resultset.ParameterHandler;
import com.yhz.mybatis.mapping.BoundSql;
import com.yhz.mybatis.mapping.MappedStatement;
import com.yhz.mybatis.mapping.SqlSource;
import com.yhz.mybatis.scripting.LanguageDriver;
import com.yhz.mybatis.scripting.defaults.DefaultParameterHandler;
import com.yhz.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * XML语言驱动器
 * @author yanhuanzhan
 * @date 2023/3/15 - 17:54
 */
public class XMLLanguageDriver implements LanguageDriver {
    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }
    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }
}
