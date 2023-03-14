package com.yhz.mybatis.executor;

import com.yhz.mybatis.executor.statement.StatementHandler;
import com.yhz.mybatis.mapping.BoundSql;
import com.yhz.mybatis.mapping.MappedStatement;
import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.session.ResultHandler;
import com.yhz.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author yanhuanzhan
 * @date 2023/3/13 - 15:23
 */
public class SimpleExecutor extends BaseExecutor{
    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try {
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            return handler.query(stmt, resultHandler);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
