package com.yhz.mybatis.executor;

import com.yhz.mybatis.mapping.BoundSql;
import com.yhz.mybatis.mapping.MappedStatement;
import com.yhz.mybatis.session.ResultHandler;
import com.yhz.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * 以 Executor 接口定义为执行器入口，确定出事务和操作和 SQL 执行的统一标准接口。
 * 并以执行器接口定义实现抽象类，也就是用抽象类处理统一共用的事务和执行SQL的标准流程，
 * 也就是这里定义的执行 SQL 的抽象接口由子类实现。
 * @author yanhuanzhan
 * @date 2023/3/13 - 15:23
 */
public interface Executor {
    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);
}
