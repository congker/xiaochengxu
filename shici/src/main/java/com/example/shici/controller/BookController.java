/**
 * @description:主页
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.controller;

import com.example.shici.entity.common.CommonPageable;
import com.example.shici.entity.common.RetResponse;
import com.example.shici.entity.common.RetResult;
import com.example.shici.entity.dto.Book;
import com.example.shici.entity.request.BookRequest;
import com.example.shici.service.BookDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("Book")
@Slf4j
public class BookController {

    @Resource
    private BookDao bookDao;

    /**
     * 获取书籍列表
     */
    @RequestMapping(value = "/getBookList")
    public RetResult<List<Book>> getBookList(@RequestBody BookRequest request) {
        CommonPageable page = request.getPage();
        return RetResponse.getOkResponse(bookDao.getBookList(page));
    }


}
