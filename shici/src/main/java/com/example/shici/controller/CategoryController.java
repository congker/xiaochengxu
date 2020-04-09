/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.controller;

import com.example.shici.entity.common.CommonPageable;
import com.example.shici.entity.common.RetResponse;
import com.example.shici.entity.common.RetResult;
import com.example.shici.entity.dto.Category;
import com.example.shici.entity.request.CategoryRequest;
import com.example.shici.service.CategoryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("Category")
@Slf4j
public class CategoryController {

    @Resource
    private CategoryDao categoryDao;

    /**
     * 获取类别列表
     */
    @RequestMapping(value = "/getCategoryList")
    public RetResult<List<Category>> getCategoryList(@RequestBody CategoryRequest categoryRequest) {
        CommonPageable page = categoryRequest.getPage();
        return RetResponse.getOkResponse(categoryDao.getCategoryList(page));
    }

}
