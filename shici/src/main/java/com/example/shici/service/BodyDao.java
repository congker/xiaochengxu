/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service;

import com.example.shici.entity.dto.Body;

public interface BodyDao {
    /**
     * 创建文章
     *
     * @param body
     */
    Body createBody(Body body);


    /**
     * 获取文章主体
     */
    Body getBodyByBookId(String bookId);


    /**
     * 获取文章主体
     */
    Body getBodyByChapterId(String chapterId);

    /**
     * 更新对象
     */
    long updateBody(Body body);

    /**
     * 删除文章
     *
     * @param id
     */
    void deleteBodyById(Long id);
}
