/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.entity.enums;

import lombok.Getter;


public enum BodyTypeEnums {
    /**
     * 书籍
     */
    BOOK("0", "书籍"),
    /**
     * 文章
     */
    ARTICLE("1", "文章");

    @Getter
    private String code;
    @Getter
    private String name;

    BodyTypeEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
