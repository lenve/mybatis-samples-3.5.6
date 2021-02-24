package org.javaboy.mybatis01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.javaboy.mybatis01.model.User;
import org.javaboy.mybatis01.utils.SqlSessionFactoryUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class Main {
    public static void main(String[] args) {
        SqlSessionFactory factory = SqlSessionFactoryUtils.getInstance();
        SqlSession sqlSession = factory.openSession();
        List<User> list = sqlSession.selectList("org.javaboy.mybatis01.mapper.UserMapper.getAllUser");
        for (User user : list) {
            System.out.println("user = " + user);
        }
        sqlSession.close();
    }
}
