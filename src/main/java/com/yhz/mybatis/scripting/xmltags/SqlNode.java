package com.yhz.mybatis.scripting.xmltags;

/**
 * SQL节点
 * @author yanhuanzhan
 * @date 2023/3/15 - 17:53
 */
public interface SqlNode {
    /**
     *
     * @param context DynamicContext是用于封装SQL语句和参数的上下文对象
     * @return
     */
    boolean apply(DynamicContext context);
}
