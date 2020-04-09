/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service.impl;

import com.example.shici.entity.dto.Category;
import com.example.shici.entity.common.CommonPageable;
import com.example.shici.service.CategoryDao;
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
public class CategoryDaoImpl implements CategoryDao {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 创建标签
     */
    @Override
    public Category createCategory(Category category) {
        return mongoTemplate.save(category);
    }

    /**
     * 标签列表
     */
    @Override
    public List<Category> getCategoryList(CommonPageable page) {
        Query query = new Query();
        query.with(page).with(new Sort(Sort.Direction.DESC, "create_time"));
        return mongoTemplate.find(query, Category.class);
    }

    /**
     * 更新目录
     */
    @Override
    public long updateCategory(Category category) {
        Query query = new Query(Criteria.where("id").is(category.getId()));
        Update update = new Update()
                .set("category_name", category.getCategoryName())
                .set("update_time", System.currentTimeMillis());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, Category.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,CategoryEntity.class);
        return result.getMatchedCount();
    }

    /**
     * 删除书籍
     */
    @Override
    public void deleteCategoryById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult result = mongoTemplate.remove(query, Category.class);
        log.info("DeleteResult:{}", result);
    }
}
