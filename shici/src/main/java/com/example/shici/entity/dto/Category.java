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
@Document(collection = "sc_category")
public class Category {
    /**
     * id
     */
    @Id
    private String id;
    /**
     * 类别名称
     */
    @Field("category_name")
    private String categoryName;
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
