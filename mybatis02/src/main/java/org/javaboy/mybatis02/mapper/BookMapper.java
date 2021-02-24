package org.javaboy.mybatis02.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.mybatis02.model.Book;

import java.util.HashMap;
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
public interface BookMapper {
    List<Book> getAllBooks();

    List<Book> getBooksByPage(@Param("start") Integer start, @Param("size") Integer size);

    /**
     * 根据书名或者作者查询书，如果两个条件同时存在时，则以书名为查询条件
     * @param book
     * @return
     */
    List<Book> getBookByNameOrAuthor(Book book);
    List<Book> getBookByNameOrAuthor2(Book book);
    List<Book> getBookByNameOrAuthor3(Book book);

    Integer updateBook(Book book);
    Integer updateBook2(Book book);
    Integer updateBook3(@Param("map") HashMap<String,Object> map,@Param("id") Long id);

    List<Book> getBooksByIds(@Param("ids") List<Long> ids);

    Integer batchAddBook(@Param("books") List<Book> books);

    List<Book> getBooksByAuthorFirstName(String author);
}
