package org.javaboy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.javaboy.mybatis02.mapper.ArticleMapper;
import org.javaboy.mybatis02.mapper.BookMapper;
import org.javaboy.mybatis02.mapper.UserMapper;
import org.javaboy.mybatis02.model.Article;
import org.javaboy.mybatis02.model.Book;
import org.javaboy.mybatis02.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 mybatis
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class MyTest {

    private UserMapper userMapper;
    private SqlSession sqlSession;
    private BookMapper bookMapper;
    private ArticleMapper articleMapper;

    @Before
    public void before() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        bookMapper = sqlSession.getMapper(BookMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
    }

    @Test
    public void addUser3() {
        User u = new User();
        u.setUsername("张三");
        u.setAddress("www.itboyhub.com");
        u.setFavorites(Arrays.asList("足球","篮球"));
        Integer result = userMapper.addUser3(u);
        System.out.println("result = " + result);
        sqlSession.commit();
    }

    @Test
    public void getAllUsersWithRole() {
        List<User> list = userMapper.getAllUsersWithRole();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void getAllUsersWithRole3() {
        List<User> list = userMapper.getAllUsersWithRole3();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void getAllUsersWithRole2() {
        List<User> list = userMapper.getAllUsersWithRole2();
        for (User user : list) {
            System.out.println("user.getRoles() = " + user.getRoles());
        }
    }

    @Test
    public void getArticleById() {
        Article article = articleMapper.getArticleById(1L);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById2() {
        Article article = articleMapper.getArticleById2(1L);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById3() {
        Article article = articleMapper.getArticleById3(1L);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById4() {
        Article article = articleMapper.getArticleById4(1L);
        System.out.println("article.getTitle() = " + article.getTitle());
//        sqlSession.close();
        System.out.println("article.getAuthor().getAge() = " + article.getAuthor().getAge());
        //        System.out.println("article = " + article);
    }

    @Test
    public void getAllUsers() {
        List<User> list = userMapper.getAllUsers();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void getUserById() {
        User user = userMapper.getUserById(17L);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserOrderBy() {
        List<User> list = userMapper.getUserOrderBy("id");
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void getUserNameContains() {
        List<User> it = userMapper.getUserNameContains("it");
        for (User user : it) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void udpateUsernameById() {
        Integer result = userMapper.updateUsernameById("itboy123", 17L);
        System.out.println("result = " + result);
        sqlSession.commit();
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("江南一点雨");
        user.setAddress("公众号：江南一点雨");
        Integer result = userMapper.addUser(user);
        System.out.println("result = " + result);
        sqlSession.commit();
        System.out.println("user = " + user);
    }

    @Test
    public void addUser2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "江南一点雨666");
        map.put("address", "微信公众号：江南一点雨");
        Integer result = userMapper.addUser2(map);
        System.out.println("result = " + result);
        sqlSession.commit();
    }

    @Test
    public void getAllUsers2() {
        List<Map<String, Object>> list = userMapper.getAllUsers2();
        for (Map<String, Object> map : list) {
            System.out.println("map = " + map);
        }
    }

    @Test
    public void getUserCount() {
        Long userCount = userMapper.getUserCount();
        System.out.println("userCount = " + userCount);
    }

    @Test
    public void getAllBooks() {
        List<Book> list = bookMapper.getAllBooks();
        for (Book book : list) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getBooksByPage() {
        List<Book> list = bookMapper.getBooksByPage(3, 3);
        for (Book book : list) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getBookByNameOrAuthor() {
        Book b = new Book();
        b.setName("三国演义");
        b.setAuthor("鲁迅");
        List<Book> list = bookMapper.getBookByNameOrAuthor3(b);
        for (Book book : list) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setId(7L);
        book.setName("呐喊666");
        book.setAuthor("鲁迅666");
        Integer result = bookMapper.updateBook2(book);
        System.out.println("result = " + result);
        sqlSession.commit();
    }

    @Test
    public void getBooksByIds() {
        List<Book> list = bookMapper.getBooksByIds(Arrays.asList(1L, 2L, 3L));
        for (Book book : list) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void batchAddBook() {
        Book b1 = new Book();
        b1.setAuthor("钱钟书");
        b1.setName("宋诗选注");
        Book b2 = new Book();
        b2.setAuthor("随园老人");
        b2.setName("随园诗话");
        Integer result = bookMapper.batchAddBook(Arrays.asList(b1, b2));
        System.out.println("result = " + result);
        sqlSession.commit();
    }

    @Test
    public void updateBook3() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("b_name", "随园诗话666");
        map.put("author", "随园老人666");
        Integer result = bookMapper.updateBook3(map, 9L);
        System.out.println("result = " + result);
        sqlSession.commit();
    }

    @Test
    public void getBooksByAuthorFirstName() {
        List<Book> list = bookMapper.getBooksByAuthorFirstName("鲁");
        for (Book book : list) {
            System.out.println("book = " + book);
        }
    }

    @After
    public void after() {
        sqlSession.close();
    }
}
