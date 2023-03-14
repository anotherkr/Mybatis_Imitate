package com.yhz.mybatis.session.defaults;

import com.yhz.mybatis.binding.MapperRegistry;
import com.yhz.mybatis.executor.Executor;
import com.yhz.mybatis.mapping.Environment;
import com.yhz.mybatis.session.Configuration;
import com.yhz.mybatis.session.SqlSession;
import com.yhz.mybatis.session.SqlSessionFactory;
import com.yhz.mybatis.session.TransactionIsolationLevel;
import com.yhz.mybatis.transaction.Transaction;
import com.yhz.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @author yanhuanzhan
 * @date 2023/3/5 - 14:20
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
