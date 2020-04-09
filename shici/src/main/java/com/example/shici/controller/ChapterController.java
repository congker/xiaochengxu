/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.controller;

import com.example.shici.entity.common.CommonPageable;
import com.example.shici.entity.common.RetResponse;
import com.example.shici.entity.common.RetResult;
import com.example.shici.entity.dto.Chapter;
import com.example.shici.entity.request.ChapterRequest;
import com.example.shici.service.ChapterDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("Chapter")
@Slf4j
public class ChapterController {

    @Resource
    private ChapterDao chapterDao;

    /**
     * 获取章节列表
     */
    @RequestMapping(value = "/getChapterList")
    public RetResult<List<Chapter>> getChapterList(@RequestBody ChapterRequest chapterRequest) {
        CommonPageable page = chapterRequest.getPage();
        return RetResponse.getOkResponse(chapterDao.getChapterList(page));
    }

}
