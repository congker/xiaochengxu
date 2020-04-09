/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service.impl;

import com.example.shici.entity.dto.Book;
import com.example.shici.entity.common.CommonPageable;
import com.example.shici.service.BookDao;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 获取
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 创建书籍
     */
    @Override
    public Book createBook(Book book) {
        return mongoTemplate.save(book);
    }

    /**
     * 根据用户名查询对象
     *
     * @return
     */
    @Override
    public List<Book> getBookList(CommonPageable page) {
        Query query = new Query();
        query.with(page).with(new Sort(Sort.Direction.DESC, "create_time"));
        return mongoTemplate.find(query, Book.class);
    }

    /**
     * 更新书籍信息
     */
    @Override
    public long updateBook(Book book) {
        Query query = new Query(Criteria.where("id").is(book.getId()));
        Update update = new Update()
                .set("book_name", book.getBookName())
                .set("author", book.getAuthor())
                .set("update_time", System.currentTimeMillis());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, Book.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,BookEntity.class);
        return result.getMatchedCount();
    }

    /**
     * 删除书籍
     */
    @Override
    public void deleteBookById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Book.class);
    }
}
