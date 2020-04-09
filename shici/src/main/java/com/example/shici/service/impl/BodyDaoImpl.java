/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service.impl;

import com.example.shici.entity.dto.Body;
import com.example.shici.service.BodyDao;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
@Slf4j
public class BodyDaoImpl implements BodyDao {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 创建文章
     */
    @Override
    public Body createBody(Body body) {
        return mongoTemplate.save(body);
    }

    /**
     * 根据BookId查询文章
     */
    @Override
    public Body getBodyByBookId(String bookId) {
        Query query = new Query(Criteria.where("book_id").is(bookId));
        return mongoTemplate.findOne(query, Body.class);
    }

    /**
     * 根据ChapterId查询文章
     */
    @Override
    public Body getBodyByChapterId(String chapterId) {
        Query query = new Query(Criteria.where("chapter_id").is(chapterId));
        return mongoTemplate.findOne(query, Body.class);
    }

    /**
     * 更新文章
     */
    @Override
    public long updateBody(Body body) {
        Query query = new Query(Criteria.where("id").is(body.getId()));
        Update update = new Update()
                .set("content", body.getContent())
                .set("update_time", System.currentTimeMillis());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, Body.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,BodyEntity.class);
        return result.getMatchedCount();
    }

    /**
     * 删除文章
     */
    @Override
    public void deleteBodyById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult result = mongoTemplate.remove(query, Body.class);
        log.info("DeleteResult:{}", result);
    }
}
