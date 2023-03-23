package com.yhz.mybatis.executor.resultset;

import com.yhz.mybatis.session.ResultContext;

/**
 * 默认结果上下文
 * @author yanhuanzhan
 * @date 2023/3/19 - 15:35
 */
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }

}