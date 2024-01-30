package com.cms.educationresources.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.entity.Subscribe;
import com.cms.educationresources.service.SubscribeService;
import com.cms.educationresources.util.OpenIdUtil;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/subscribe")
public class SubscribeCotroller {
    private OpenIdUtil openIdUtil;
    @Autowired
    private SubscribeService subscribeService;

    @PostMapping("/isSub")
    public R isSub(@RequestBody Subscribe subscribe) throws IOException, ParseException {
        String userId = openIdUtil.getOpenId(subscribe.getUserid());
        Subscribe subscribe1 = subscribeService.getOne(new QueryWrapper<Subscribe>().eq("bookName", subscribe.getBookname()).eq("userId", userId));
        Map<String, Object> map = new HashMap<>();
        if (subscribe1 == null) {
            map.put("isSub", false);
        }else {
            map.put("isSub", true);
        }
        return R.ok(map);
    }

    @PostMapping("/add")
    public R add(@RequestBody Subscribe subscribe) throws IOException, ParseException {
        String userId = openIdUtil.getOpenId(subscribe.getUserid());
        Subscribe subscribe1 = subscribeService.getOne(new QueryWrapper<Subscribe>().eq("bookName", subscribe.getBookname()).eq("userId",userId));
        if (subscribe1 == null) {
            subscribe.setUserid(userId);
            subscribeService.save(subscribe);
        }else {
            System.out.println("已订阅");
        }
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Subscribe subscribe) throws IOException, ParseException {
        String userId = openIdUtil.getOpenId(subscribe.getUserid());
        subscribeService.remove(new QueryWrapper<Subscribe>().eq("bookName", subscribe.getBookname()).eq("userId",userId));
        return R.ok();
    }
}
