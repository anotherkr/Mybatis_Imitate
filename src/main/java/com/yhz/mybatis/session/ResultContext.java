package com.yhz.mybatis.session;

/**
 * 结果上下文
 * @author yanhuanzhan
 * @date 2023/3/19 - 15:37
 */
public interface ResultContext {
    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();
}
