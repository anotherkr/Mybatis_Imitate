package com.yhz.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yanhuanzhan
 * @date 2023/3/17 - 16:20
 */
public class LongTypeHandler extends BaseTypeHandler<Long>{
    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
        //i 是 PreparedStatement 对象的参数下标，它的值从参数列表中获取
        ps.setLong(i, parameter);
    }
    @Override
    protected Long getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getLong(columnName);
    }
}
