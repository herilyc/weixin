package com.cms.educationresources.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cms.educationresources.entity.Conversations;
import com.cms.educationresources.entity.R;
import com.cms.educationresources.entity.User;
import com.cms.educationresources.service.ConversationsService;
import com.cms.educationresources.service.UserService;
import com.cms.educationresources.util.OpenIdUtil;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conversations")
public class ConversationsController {
    @Autowired
    private ConversationsService conversationsService;
    @Autowired
    private UserService userService;
    private OpenIdUtil openIdUtil;

    @GetMapping("/findConversations")
    public R findConversations(@RequestParam String code) throws IOException, ParseException {
        String openId = openIdUtil.getOpenId(code);
        List<Conversations> conversations = conversationsService.list(new QueryWrapper<Conversations>()
                .eq("sender", code).groupBy("receiver"));
        User receiver;
        Conversations temp;
        for (Conversations conversation : conversations) {
            receiver = userService.getOne(new QueryWrapper<User>().eq("id", conversation.getReceiver()));
            conversation.setReceiverName(receiver.getRealname());
            temp = conversationsService.getOne(new QueryWrapper<Conversations>()
                    .eq("sender", conversation.getSender())
                    .eq("receiver", conversation.getReceiver())
                    .orderByDesc("time").last("limit 1"));
            conversation.setTime(temp.getTime());
            conversation.setMessage(temp.getMessage());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("conversations", conversations);
        return R.ok(map);
    }

    @PostMapping("/newChat")
    public R newChat(@RequestBody Conversations conversation) throws IOException, ParseException {
        String sender = openIdUtil.getOpenId(conversation.getSenderCode());
        String receiver = openIdUtil.getOpenId(conversation.getReceiverCode());
        User userInfo = userService.getById(receiver);
        conversation.setAvatarurl(userInfo.getAvatarurl());    //receiver的头像
        conversation.setTime(new Date());
        conversation.setReceiver(receiver);
        conversation.setSender(sender);
        conversationsService.save(conversation);
        return R.ok();
    }

    @GetMapping("/findMsgByReceiver")
    public R findMsgByReceiver(@RequestParam("receiver") String receiver ,@RequestParam("sender") String sender) throws IOException, ParseException {
        String senderId = openIdUtil.getOpenId(sender);
        User teacher = userService.getOne(new QueryWrapper<User>().eq("realName", receiver));
        String receiverId = teacher.getId();
        List<Conversations> messages = conversationsService.list(new QueryWrapper<Conversations>()
                .and(i -> i.eq("sender", senderId).or().eq("sender", receiverId))
                .and(j -> j.eq("receiver", receiverId).or().eq("receiver", senderId))
                .orderByAsc("time"));
        Map<String, Object> map = new HashMap<>();
        map.put("messages", messages);
        return R.ok(map);
    }
}
