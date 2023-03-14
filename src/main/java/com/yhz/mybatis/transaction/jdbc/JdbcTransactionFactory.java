package com.yhz.mybatis.transaction.jdbc;

import com.yhz.mybatis.session.TransactionIsolationLevel;
import com.yhz.mybatis.transaction.Transaction;
import com.yhz.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author yanhuanzhan
 * @date 2023/3/8 - 16:09
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
