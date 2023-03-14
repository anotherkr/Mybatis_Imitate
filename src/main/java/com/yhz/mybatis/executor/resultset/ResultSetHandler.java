package com.yhz.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 结果集处理器
 * @author yanhuanzhan
 * @date 2023/3/13 - 15:22
 */
public interface ResultSetHandler {
    <E> List<E> handleResultSets(Statement stmt) throws SQLException;
}
