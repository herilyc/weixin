package com.cms.educationresources.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.entity.User;
import com.cms.educationresources.service.UserService;
import com.cms.educationresources.util.JwtUtil;
import com.cms.educationresources.util.OpenIdUtil;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private OpenIdUtil openIdUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/teacherInfo")
    public R teacherInfo(@RequestBody User user) throws IOException, ParseException {
        String openid = openIdUtil.getOpenId(user);
        User userInfo = userService.getById(openid);
        userInfo.setGender(user.getGender());
        userInfo.setIntroduction(user.getIntroduction());
        userInfo.setPassword(user.getPassword());
        userInfo.setRealname(user.getRealname());
        userInfo.setIsteacher(user.getIsteacher());
        userService.updateById(userInfo);
        return R.ok();
    }

    @PostMapping("/login")
    public R login(@RequestBody User user) throws IOException, ParseException {
        String openid = openIdUtil.getOpenId(user);
//        插入数据库
        User userInfo = userService.getOne(new QueryWrapper<User>().eq("id", openid));
        if (userInfo == null) {
            user.setId(openid);
            userService.save(user);
        }else {
            userInfo.setAvatarurl(user.getAvatarurl());
            userInfo.setNickname(user.getNickname());
            userService.updateById(userInfo);
        }
//        jwt token
        String token = jwtUtil.createToken(openid);
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        return R.ok(map);
    }

    @GetMapping("/isTeacher")
    public R isTeacher(@RequestParam String code) throws IOException, ParseException {
        String openId = openIdUtil.getOpenId(code);
        User userInfo = userService.getOne(new QueryWrapper<User>().eq("id", openId));
        Map<String,Object> map = new HashMap<>();
        map.put("isteacher", userInfo.getIsteacher());
        return R.ok(map);
    }
}
