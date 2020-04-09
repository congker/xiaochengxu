package com.example.shici;

import com.example.shici.entity.dto.Book;
import com.example.shici.service.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {

    @Resource
    BookDao bookDao;

    @Test
    public void create() {
        Book book = new Book();
        book.setBookName("鬼吹灯");
        book.setAuthor("天下霸唱");
        book.setCategoryId("");
        bookDao.createBook(book);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }


}
