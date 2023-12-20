package com.cms.educationresources.controller;

import com.cms.educationresources.entity.Category;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/subject")
    public R findSwiper() {
        List<Category> subjectList = categoryService.list();
        Map<String, Object> map = new HashMap<>();
        map.put("subjects", subjectList);
        return R.ok(map);
    }
}
