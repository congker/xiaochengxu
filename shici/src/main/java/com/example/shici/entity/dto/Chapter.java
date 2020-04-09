/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.entity.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "sc_chapter")
public class Chapter {
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 章节名称
     */
    @Field("chapter_name")
    private String chapterName;
    /**
     * 关联书籍
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
