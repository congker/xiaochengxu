/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service.impl;

import com.example.shici.entity.dto.Body;
import com.example.shici.entity.dto.Chapter;
import com.example.shici.entity.common.CommonPageable;
import com.example.shici.service.ChapterDao;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Slf4j
public class ChapterDaoImpl implements ChapterDao {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 创建章节
     */
    @Override
    public Chapter createChapter(Chapter chapter) {
        return mongoTemplate.save(chapter);
    }

    /**
     * 根据用户名查询对象
     */
    @Override
    public List<Chapter> getChapterList(CommonPageable page) {
        Query query = new Query();
        query.with(page).with(new Sort(Sort.Direction.DESC, "create_time"));
        return mongoTemplate.find(query, Chapter.class);
    }

    /**
     * 更新章节
     */
    @Override
    public long updateChapter(Chapter chapter) {
        Query query = new Query(Criteria.where("id").is(chapter.getId()));
        Update update = new Update().set("chapter_name", chapter.getChapterName())
                .set("update_time", System.currentTimeMillis());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, Body.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,ChapterEntity.class);
        return result.getMatchedCount();
    }

    /**
     * 删除对象
     */
    @Override
    public void deleteChapterById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult result = mongoTemplate.remove(query, Chapter.class);
        log.info("DeleteResult:{}" + result);

    }
}
