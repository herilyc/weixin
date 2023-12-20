package com.cms.educationresources.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cms.educationresources.entity.Book;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/findSwiper")
    public R findSwiper() {
        List<Book> swiperList = bookService.list(new QueryWrapper<Book>().eq("isSwiper", true).orderByAsc("swiperSort"));
        Map<String, Object> map = new HashMap<>();
        map.put("message", swiperList);
        return R.ok(map);
    }
}
