package com.cms.educationresources.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cms.educationresources.entity.Book;
import com.cms.educationresources.service.BookService;
import com.cms.educationresources.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author cjl
* @description 针对表【book】的数据库操作Service实现
* @createDate 2024-01-19 14:45:07
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




