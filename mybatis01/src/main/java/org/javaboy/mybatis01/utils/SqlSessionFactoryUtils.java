package org.javaboy.mybatis01.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class SqlSessionFactoryUtils {
    private static SqlSessionFactory SQLSESSIONFACTORY = null;
    public static SqlSessionFactory getInstance() {
        if (SQLSESSIONFACTORY == null) {
            try {
                SQLSESSIONFACTORY = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SQLSESSIONFACTORY;
    }
}
