package org.javaboy.mybatis03.mapper;

import org.apache.ibatis.session.RowBounds;
import org.javaboy.mybatis03.model.User;

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
    User getUserById(Long id);

    List<User> getAllUsersByPage(RowBounds rowBounds,User user);
}