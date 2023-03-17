package com.yhz.mybatis.scripting.xmltags;

/**
 * 静态文本SQL节点
 * @author yanhuanzhan
 * @date 2023/3/15 - 17:54
 */
public class StaticTextSqlNode implements SqlNode{
    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }
}
