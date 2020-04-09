/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service;

import com.example.shici.entity.dto.Book;
import com.example.shici.entity.common.CommonPageable;

import java.util.List;

public interface BookDao {

    /**
     * 新增书籍
     *
     * @param book
     */
    Book createBook(Book book);

    /**
     * 获取书籍列表
     *
     * @param
     * @return
     */
    List<Book> getBookList(CommonPageable page);

    /**
     * 更新对象
     *
     * @param book
     */
    long updateBook(Book book);

    /**
     * 删除对象
     *
     * @param id
     */
    void deleteBookById(Long id);
}
