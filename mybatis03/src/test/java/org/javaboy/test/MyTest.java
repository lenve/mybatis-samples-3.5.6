package org.javaboy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.javaboy.mybatis03.mapper.BookMapper;
import org.javaboy.mybatis03.mapper.UserMapper;
import org.javaboy.mybatis03.model.User;
import org.javaboy.mybatis03.plugin.PageRowBounds;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class MyTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void test4() {
        BookMapper bookMapper = sqlSessionFactory.openSession().getMapper(BookMapper.class);
        List<Map<String, Object>> list = bookMapper.getAllBooks();
        for (Map<String, Object> map : list) {
            System.out.println("map = " + map);
        }
    }

    @Test
    public void test3() {
        UserMapper userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        PageRowBounds pageRowBounds = new PageRowBounds(1, 2);
        User u = new User();
        u.setUsername("江南一点雨");
        List<User> list = userMapper.getAllUsersByPage(pageRowBounds, u);
        for (User user : list) {
            System.out.println("user = " + user);
        }
        System.out.println("pageRowBounds.getTotal() = " + pageRowBounds.getTotal());
    }

    @Test
    public void test2() {
        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper um1 = session1.getMapper(UserMapper.class);
        User user = um1.getUserById(17L);
        System.out.println("user = " + user);
        user.setUsername("javaboy");
        session1.close();
        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper um2 = session2.getMapper(UserMapper.class);
        User u2 = um2.getUserById(17L);
        System.out.println("u2 = " + u2);
    }

    @Test
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(17L);
        System.out.println("user = " + user);
        user.setUsername("javaboy");
        User user2 = userMapper.getUserById(17L);
        System.out.println("user2 = " + user2);
        sqlSession.close();
    }

}
