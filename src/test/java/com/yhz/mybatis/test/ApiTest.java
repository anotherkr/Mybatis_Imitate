package com.yhz.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.yhz.mybatis.binding.MapperProxyFactory;
import com.yhz.mybatis.dao.IUserDao;
import com.yhz.mybatis.io.Resources;
import com.yhz.mybatis.po.Teacher;
import com.yhz.mybatis.po.User;
import com.yhz.mybatis.reflection.MetaObject;
import com.yhz.mybatis.reflection.SystemMetaObject;
import com.yhz.mybatis.session.SqlSession;
import com.yhz.mybatis.session.SqlSessionFactory;
import com.yhz.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        //// 1. 从SqlSessionFactory中获取SqlSession
        //Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //
        //// 2. 获取映射器对象
        //IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //
        //// 3. 测试验证
        //String res = userDao.queryUserInfoById(10001L);
        //logger.info("测试结果：{}", res);
    }
    @Test
    public void test_04() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User res = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", res);
    }
    @Test
    public void test_05() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            logger.info("测试结果：{}", JSON.toJSONString(user));
        }
    }
    @Test
    public void test_06() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
            User user = userDao.queryUserInfoById(1L);
            logger.info("测试结果：{}", JSON.toJSONString(user));

    }
    @Test
    public void test_reflection() {
        Teacher teacher = new Teacher();
        List<Teacher.Student> list = new ArrayList<>();
        list.add(new Teacher.Student());
        teacher.setName("yhz");
        teacher.setStudents(list);

        MetaObject metaObject = SystemMetaObject.forObject(teacher);

        logger.info("getGetterNames：{}", JSON.toJSONString(metaObject.getGetterNames()));
        logger.info("getSetterNames：{}", JSON.toJSONString(metaObject.getSetterNames()));
        logger.info("name的get方法返回值：{}", JSON.toJSONString(metaObject.getGetterType("name")));
        logger.info("students的set方法参数值：{}", JSON.toJSONString(metaObject.getGetterType("students")));
        logger.info("name的hasGetter：{}", metaObject.hasGetter("name"));
        logger.info("student.id（属性为对象）的hasGetter：{}", metaObject.hasGetter("student.id"));
        logger.info("获取name的属性值：{}", metaObject.getValue("name"));
        // 重新设置属性值
        metaObject.setValue("name", "小白");
        logger.info("设置name的属性值：{}", metaObject.getValue("name"));
        // 设置属性（集合）的元素值
        metaObject.setValue("students[0].id", "001");
        logger.info("获取students集合的第一个元素的属性值：{}", JSON.toJSONString(metaObject.getValue("students[0].id")));
        logger.info("对象的序列化：{}", JSON.toJSONString(teacher));
    }
}
