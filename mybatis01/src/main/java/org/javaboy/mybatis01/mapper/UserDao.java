package org.javaboy.mybatis01.mapper;

import com.mysql.cj.xdevapi.SqlUpdateResult;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaboy.mybatis01.model.User;
import org.javaboy.mybatis01.utils.SqlSessionFactoryUtils;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class UserDao {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();

    public Integer addUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("org.javaboy.mybatis01.mapper.UserMapper.addUser", user);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }

    public Integer deleteUserById(Long id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("org.javaboy.mybatis01.mapper.UserMapper.deleteUserById", id);
        sqlSession.commit();
        sqlSession.close();
        return delete;
    }

    public Integer updateUserById(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int update = sqlSession.update("org.javaboy.mybatis01.mapper.UserMapper.updateUserById", user);
        sqlSession.commit();
        sqlSession.close();
        return update;
    }
}
