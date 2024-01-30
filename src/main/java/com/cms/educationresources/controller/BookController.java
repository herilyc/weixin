package com.cms.educationresources.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cms.educationresources.entity.Book;
import com.cms.educationresources.entity.Category;
import com.cms.educationresources.entity.Grade;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.service.BookService;
import com.cms.educationresources.service.CategoryService;
import com.cms.educationresources.service.GradeService;
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
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GradeService gradeService;

    @GetMapping("/findSwiper")
    public R findSwiper() {
        List<Book> swiperList = bookService.list(new QueryWrapper<Book>()
                .eq("isSwiper", true).orderByAsc("swiperSort"));
        Map<String, Object> map = new HashMap<>();
        map.put("message", swiperList);
        return R.ok(map);
    }

    @GetMapping("/findBySubject")
    public R findBySubject() {
        List<Category> categories = categoryService.list();
        for (Category category : categories) {
            List<Book> bookList = bookService.list(new QueryWrapper<Book>()
                    .eq("subject", category.getSubject()));
            category.setSbjBookList(bookList);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("sbjBooks", categories);
        return R.ok(map);
    }

    @GetMapping("/findAll")
    public R findAll() {
        List<Book> bookList = bookService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("allBooks", bookList);
        return R.ok(map);
    }

    @GetMapping("/findByGrade")
    public R findByGrade() {
        List<Grade> grades = gradeService.list(new QueryWrapper<Grade>().orderByAsc("id"));
        for (Grade grade: grades) {
            List<Book> bookList = bookService.list(new QueryWrapper<Book>()
                    .eq("grade", grade.getGrade()));
            grade.setGradeBookList(bookList);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("gradeBooks", grades);
        return R.ok(map);
    }

    @GetMapping("/findByBoth")
    public R findByBoth() {
        Map<String, Object> map = new HashMap<>();
        List<Grade> grades = gradeService.list(new QueryWrapper<Grade>().orderByAsc("id"));
        List<Category> categories = categoryService.list();
        HashMap<String, Object> paramsMap = new HashMap<>(4);
        for (Grade grade: grades) {
            for (Category category : categories) {
                paramsMap.put("grade", grade.getGrade());
                paramsMap.put("subject", category.getSubject());
                List<Book> bookList = bookService.listByMap(paramsMap);
                paramsMap.clear();
                map.put(grade.getGrade() + category.getSubject(), bookList);
            }
        }
        return R.ok(map);
    }
}
