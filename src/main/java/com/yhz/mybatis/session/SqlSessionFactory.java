package com.yhz.mybatis.session;

/**
 * @author yanhuanzhan
 * @date 2023/3/5 - 14:19
 */
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
