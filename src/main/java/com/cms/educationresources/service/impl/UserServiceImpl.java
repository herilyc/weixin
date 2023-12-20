package com.cms.educationresources.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cms.educationresources.entity.User;
import com.cms.educationresources.service.UserService;
import com.cms.educationresources.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author cjl
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-12-20 17:41:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




