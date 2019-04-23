package com.baizhi.controller;

import com.baizhi.Application;
import com.baizhi.entity.Book;
import com.baizhi.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestController {
    @Autowired
    private BookRepository bookRepository;
    @Test
    //测试添加与更新
    public void testSaveorUpdate(){
        Book book=new Book();
        book.setId("1");
        book.setName("三国");
        book.setCreateDate(new Date());
        book.setAuthor("罗贯中");
        book.setContent("滚滚长江东逝水，浪花淘尽英雄，是非成败转头空，几度夕阳红！");
        bookRepository.save(book);
    }
    @Test
    //测试删除
    public void testDel(){
        Book book = new Book();
        book.setId("1");
        bookRepository.delete(book);
    }
    @Test
    //查询所有
    public void findAll(){
        Iterable<Book> all = bookRepository.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }
    @Test
    //查询一个
    public void findOne(){
        Optional<Book> byId = bookRepository.findById("1");
        System.out.println(byId.get());
    }


}
