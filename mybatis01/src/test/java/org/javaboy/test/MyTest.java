package org.javaboy.test;

import org.apache.ibatis.session.SqlSession;
import org.javaboy.mybatis01.mapper.UserMapper;
import org.javaboy.mybatis01.model.User;
import org.javaboy.mybatis01.utils.SqlSessionFactoryUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

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
    private SqlSession sqlSession;
    @Before
    public void before() {
        sqlSession = SqlSessionFactoryUtils.getInstance().openSession();
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("itboy123");
        user.setAddress("www.itboyhub.com");
//        user.setId(UUID.randomUUID().toString());
        int insert = sqlSession.insert("org.javaboy.mybatis01.mapper.UserMapper.addUser", user);
        System.out.println("insert = " + insert);
        sqlSession.commit();
    }

    @Test
    public void deleteUserById() {
        int delete = sqlSession.delete("org.javaboy.mybatis01.mapper.UserMapper.deleteUserById", 16L);
        sqlSession.commit();
        System.out.println("delete = " + delete);
    }

    @Test
    public void updateUserById() {
        User user = new User();
        user.setId(15L);
        user.setUsername("itboy666");
        int update = sqlSession.update("org.javaboy.mybatis01.mapper.UserMapper.updateUserById", user);
        sqlSession.commit();
        System.out.println("update = " + update);
    }

    @Test
    public void getUserById() {
        User user = (User) sqlSession.selectOne("org.javaboy.mybatis01.mapper.UserMapper.getUserById", 17L);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserById2() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(17L);
        System.out.println("user = " + user);
    }

    @After
    public void after() {
        sqlSession.close();
    }
}
