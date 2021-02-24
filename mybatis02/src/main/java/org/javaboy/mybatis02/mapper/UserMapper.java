package org.javaboy.mybatis02.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.mybatis02.model.User;

import java.util.HashMap;
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
public interface UserMapper {
    List<User> getAllUsers();
    List<Map<String,Object>> getAllUsers2();
    List<User> getUserOrderBy(String orderby);

    List<User> getUserNameContains(String name);

    Integer updateUsernameById(@Param("username") String username, @Param("id") Long id);

    Integer addUser(@Param("user") User user);
    Integer addUser2(@Param("user") HashMap<String,Object> map);

    User getUserById(Long id);

    Long getUserCount();

    List<User> getAllUsersWithRole();
    List<User> getAllUsersWithRole2();
    List<User> getAllUsersWithRole3();

    Integer addUser3(User user);
}
