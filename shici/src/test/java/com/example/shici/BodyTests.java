package com.example.shici;

import com.example.shici.entity.dto.Category;
import com.example.shici.service.CategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BodyTests {
    @Resource
    CategoryDao categoryDao;

    @Test
    public void create() {
        Category category = new Category();
        categoryDao.createCategory(category);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }


}
