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
@RequestMapping("Search")
@Slf4j
public class SearchController {
    /**
     *  根据参数进行搜索
     * */
    @RequestMapping(value = "/search")
    public String test(@RequestParam String param) {
        log.info("param:", param);
        return param;
    }
}
