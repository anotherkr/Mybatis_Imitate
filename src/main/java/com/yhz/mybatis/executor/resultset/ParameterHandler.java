package com.yhz.mybatis.executor.resultset;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author yanhuanzhan
 * @date 2023/3/17 - 16:19
 */
public interface ParameterHandler {
    /**
     * 获取参数
     */
    Object getParameterObject();

    /**
     * 设置参数
     */
    void setParameters(PreparedStatement ps) throws SQLException;
}
