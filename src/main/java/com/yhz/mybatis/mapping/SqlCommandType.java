package com.yhz.mybatis.mapping;

import org.omg.CORBA.UNKNOWN;

/**
 * @author yanhuanzhan
 * @date 2023/3/7 - 0:45
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
