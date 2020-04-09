package com.example.shici;

import com.example.shici.entity.dto.Category;
import com.example.shici.entity.common.PageModel;
import com.example.shici.entity.common.CommonPageable;
import com.example.shici.service.CategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTests {
    @Resource
    CategoryDao categoryDao;

    public static final List<String> categoryList = Arrays.asList("经济", "历史", "文化", "建筑", "考古", "政治", "旅游", "美食", "教育","户外");


    @Test
    public void create() {
        Long time = System.currentTimeMillis();
        for (String item : categoryList) {
            Category category = new Category();
            category.setCategoryName(item);
            category.setCreateTime(time);
            category.setUpdateTime(time);
            Category result = categoryDao.createCategory(category);
            System.out.println("result:" + result);
        }

    }

    @Test
    public void getCategoryList() {
        CommonPageable pageable = new CommonPageable();
        PageModel pageModel = new PageModel();
        pageModel.setSort(new Sort(Sort.Direction.DESC, "create_time"));
        pageModel.setPagenumber(1);
        pageable.setPage(pageModel);
        List<Category> list = categoryDao.getCategoryList(pageable);
        System.out.println("list:" + list);
    }


    @Test
    public void update() {

    }

    @Test
    public void delete() {
    }


}
