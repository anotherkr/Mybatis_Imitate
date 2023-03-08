package com.yhz.mybatis.test;

import com.yhz.mybatis.binding.MapperProxyFactory;
import com.yhz.mybatis.binding.MapperRegistry;
import com.yhz.mybatis.dao.IUserDao;
import com.yhz.mybatis.io.Resources;
import com.yhz.mybatis.po.User;
import com.yhz.mybatis.session.SqlSession;
import com.yhz.mybatis.session.SqlSessionFactory;
import com.yhz.mybatis.session.SqlSessionFactoryBuilder;
import com.yhz.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanhuanzhan
 * @date 2023/3/4 - 17:55
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_01() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("com.yhz.mybatis.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.yhz.mybatis.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        //IUserDao userDao = factory.newInstance(sqlSession);
        //String res = userDao.queryUserName("10001");
        //System.out.println("测试结果:"+res);
    }
    @Test
    public void test_02() {
        // 1. 注册 Mapper
        //MapperRegistry registry = new MapperRegistry();
        //registry.addMappers("com.yhz.mybatis.dao");
        //
        //// 2. 从 SqlSession 工厂获取 Session
        //SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //
        //// 3. 获取映射器对象
        //IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //
        //// 4. 测试验证
        //String res = userDao.queryUserName("10001");
        //logger.info("测试结果：{}", res);
    }

    @Test
    public void test_03() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById(10001L);
        logger.info("测试结果：{}", res);
    }
}
