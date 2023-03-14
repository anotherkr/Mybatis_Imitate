package com.yhz.mybatis.executor.statement;

import com.yhz.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 语句处理器的核心包括了；准备语句、参数化传递参数、执行查询的操作，
 * 这里对应的 Mybatis 源码中还包括了 update、批处理、获取参数处理器等。
 * @author yanhuanzhan
 * @date 2023/3/13 - 15:23
 */
public interface StatementHandler {
    /** 准备语句 */
    Statement prepare(Connection connection) throws SQLException;

    /** 参数化 */
    void parameterize(Statement statement) throws SQLException;

    /** 执行查询 */
    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;
}
