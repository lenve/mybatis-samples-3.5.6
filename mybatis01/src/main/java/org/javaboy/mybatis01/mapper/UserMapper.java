package org.javaboy.mybatis01.mapper;

import org.apache.ibatis.session.SqlSession;
import org.javaboy.mybatis01.model.User;

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
public interface UserMapper {
    Integer addUser(User user);

    Integer deleteUserById(Long id);

    Integer updateUserById(User user);

    User getUserById(Long id);

    List<User> getAllUser();
}