package org.javaboy.ssm.service;

import org.javaboy.ssm.mapper.UserMapper;
import org.javaboy.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}