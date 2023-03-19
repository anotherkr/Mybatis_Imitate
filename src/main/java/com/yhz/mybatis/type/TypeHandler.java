package com.yhz.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author yanhuanzhan
 * @date 2023/3/15 - 16:07
 */
public interface TypeHandler<T> {
    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;
}
