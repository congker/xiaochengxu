/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.entity.request;

import lombok.Data;

@Data
public class BodyRequest {

    /**
     *  书籍id
     * */
    String bookId;
    /**
     *  章节id
     * */
    String chapterId;
}
