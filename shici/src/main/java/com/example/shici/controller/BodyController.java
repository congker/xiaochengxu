/**
 * @description:主页
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.controller;

import com.example.shici.entity.common.CommonPageable;
import com.example.shici.entity.common.RetResponse;
import com.example.shici.entity.common.RetResult;
import com.example.shici.entity.dto.Body;
import com.example.shici.entity.dto.Book;
import com.example.shici.entity.request.BodyRequest;
import com.example.shici.entity.request.BookRequest;
import com.example.shici.service.BodyDao;
import com.example.shici.service.BookDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("Body")
@Slf4j
public class BodyController {

    @Resource
    private BodyDao bodyDao;

    /**
     * 获取文章主体内容
     */
    @RequestMapping(value = "/getContent")
    public RetResult<Body> getContent(@RequestBody BodyRequest request) {
        String bookId = request.getBookId();
        String chapterId = request.getChapterId();
        if (!StringUtils.isEmpty(bookId)) {
            return RetResponse.getOkResponse(bodyDao.getBodyByBookId(bookId));
        } else if (!StringUtils.isEmpty(chapterId)) {
            return RetResponse.getOkResponse(bodyDao.getBodyByBookId(bookId));
        }
        return RetResponse.getErrorResponse("找不到文章");
    }


}
