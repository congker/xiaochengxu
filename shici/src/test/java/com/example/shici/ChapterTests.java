package com.example.shici;

import com.example.shici.entity.dto.Chapter;
import com.example.shici.entity.common.CommonPageable;
import com.example.shici.entity.common.PageModel;
import com.example.shici.service.ChapterDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTests {
    @Resource
    ChapterDao chapterDao;

    @Test
    public void create() {
        Chapter chapter = new Chapter();
        Chapter result = chapterDao.createChapter(chapter);
        System.out.println("result:" + result);
    }

    @Test
    public void getChapterList() {
        CommonPageable pageable = new CommonPageable();
        PageModel pageModel = new PageModel();
        pageModel.setPagenumber(1);
        pageModel.setSort(new Sort(Sort.Direction.DESC, "create_time"));
        pageable.setPage(pageModel);
        List<Chapter> list = chapterDao.getChapterList(pageable);
        System.out.println("list:" + list);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }


}
