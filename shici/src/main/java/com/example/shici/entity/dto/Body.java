/**
 * @description:文章主体
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.entity.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "sc_body")
public class Body {
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 主体
     */
    @Field("content")
    private String content;
    /**
     * 关联章节
     */
    @Field("chapter_id")
    private String chapterId;
    /**
     * 关联book
     */
    @Field("book_id")
    private String bookId;
    /**
     * 创建时间
     */
    @Field("create_time")
    private Long createTime;
    /**
     * 更新时间
     */
    @Field("update_time")
    private Long updateTime;
}
