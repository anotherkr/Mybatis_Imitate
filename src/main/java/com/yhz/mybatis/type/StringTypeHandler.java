package com.yhz.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author yanhuanzhan
 * @date 2023/3/17 - 16:20
 */
public class StringTypeHandler extends BaseTypeHandler<String>{

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }

}