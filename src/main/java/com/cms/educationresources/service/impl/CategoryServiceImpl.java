package com.cms.educationresources.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cms.educationresources.entity.Category;
import com.cms.educationresources.service.CategoryService;
import com.cms.educationresources.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author cjl
* @description 针对表【category】的数据库操作Service实现
* @createDate 2023-12-20 17:41:53
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




