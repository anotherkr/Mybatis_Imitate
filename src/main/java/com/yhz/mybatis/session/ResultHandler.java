package com.yhz.mybatis.session;

/**
 * @author yanhuanzhan
 * @date 2023/3/13 - 15:24
 */
public interface ResultHandler {
    /**
     * 处理结果
     * @param context
     */
    void handleResult(ResultContext context);
}
