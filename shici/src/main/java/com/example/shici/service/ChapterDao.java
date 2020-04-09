/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service;

import com.example.shici.entity.dto.Chapter;
import com.example.shici.entity.common.CommonPageable;

import java.util.List;

public interface ChapterDao {
    /**
     * 创建章节
     */
    Chapter createChapter(Chapter chapter);

    /**
     * 查询章节列表
     */
    List<Chapter> getChapterList(CommonPageable page);

    /**
     * 更新
     *
     * @param chapter
     */
    long updateChapter(Chapter chapter);

    /**
     * 删除章节
     */
    void deleteChapterById(Long id);
}
