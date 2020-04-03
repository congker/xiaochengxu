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
     *  方法描述
     * */
    @RequestMapping(value = "/test")
    public String test(@RequestParam String param) {
        log.info("param:", param);
        return param;
    }
}
