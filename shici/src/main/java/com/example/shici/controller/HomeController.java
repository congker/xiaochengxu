/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Home")
@Slf4j
public class HomeController {
    /**
     * 获取tab列表
     */
    @RequestMapping(value = "/getTabList")
    public String getTabList(@RequestParam String param) {
        log.info("param:", param);
        return param;
    }

    /**
     * 获取文章列表（分页）
     */
    @RequestMapping(value = "/getArticleList")
    public String getArticleList(@RequestParam String param) {
        log.info("param:", param);
        return param;
    }

    /**
     * 获取文章详情
     */
    @RequestMapping(value = "/getArticleDetail")
    public String getArticleDetail(@RequestParam String param) {
        log.info("param:", param);
        return param;
    }


}
