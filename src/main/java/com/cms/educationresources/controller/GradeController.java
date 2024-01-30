package com.cms.educationresources.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cms.educationresources.entity.Category;
import com.cms.educationresources.entity.Grade;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @GetMapping("/grade")
    public R findSwiper() {
        List<Grade> gradeList = gradeService.list(new QueryWrapper<Grade>().orderByAsc("id"));
        Map<String, Object> map = new HashMap<>();
        map.put("grades", gradeList);
        return R.ok(map);
    }
}
