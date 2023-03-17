package com.yhz.mybatis.scripting.xmltags;

import com.yhz.mybatis.builder.BaseBuilder;
import com.yhz.mybatis.mapping.SqlSource;
import com.yhz.mybatis.scripting.defaults.RawSqlSource;
import com.yhz.mybatis.session.Configuration;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * XML脚本语言构建器，用于解析XML脚本并生成一个SqlSource对象，以便执行SQL查询。
 * @author yanhuanzhan
 * @date 2023/3/15 - 17:54
 */
public class XMLScriptBuilder extends BaseBuilder {
    /**
     * 用于解析XML脚本并生成一个SqlSource对象，以便执行SQL查询。
     */
    private Element element;
    /**
     * 表示SQL脚本是否包含动态SQL
     */
    private boolean isDynamic;
    /**
     * 传递给SQL脚本的参数的类
     */
    private Class<?> parameterType;

    public XMLScriptBuilder(Configuration configuration, Element element, Class<?> parameterType) {
        super(configuration);
        this.element = element;
        this.parameterType = parameterType;
    }

    /**
     * 返回从解析的XML脚本生成的SqlSource对象
     * @return
     */
    public SqlSource parseScriptNode() {
        List<SqlNode> contents = parseDynamicTags(element);
        MixedSqlNode rootSqlNode = new MixedSqlNode(contents);
        return new RawSqlSource(configuration, rootSqlNode, parameterType);
    }

    List<SqlNode> parseDynamicTags(Element element) {
        List<SqlNode> contents = new ArrayList<>();
        // element.getText 拿到 SQL
        String data = element.getText();
        //StaticTextSqlNode是MyBatis框架中用于表示静态SQL语句的节点类型
        contents.add(new StaticTextSqlNode(data));
        return contents;
    }

}
