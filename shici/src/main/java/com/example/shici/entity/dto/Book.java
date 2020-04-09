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

import javax.xml.bind.annotation.XmlEnum;

@Data
@Document(collection = "sc_book")
public class Book {
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 书名
     */
    @Field("book_name")
    private String bookName;
    /**
     * 所属类别
     */
    @Field("category_id")
    private String categoryId;
    /**
     * 作者
     */
    @Field("author")
    private String author;
    /**
     * 文体类别
     */
    @Field("body_type")
    private String bodyType;
    /**
     * 创建时间
     */
    @Field("create_time")
    private Long createTime = System.currentTimeMillis();
    /**
     * 更新时间
     */
    @Field("update_time")
    private Long updateTime = System.currentTimeMillis();

}
