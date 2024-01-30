package com.cms.educationresources.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.cms.educationresources.entity.User;
import com.cms.educationresources.properties.weixinProperties;
import lombok.Data;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Data
public class OpenIdUtil {
    @Autowired
    private weixinProperties weixinProperties;

    public String getOpenId(String code) throws IOException, ParseException {
        String jsCode2SessionUrl = weixinProperties.getJsCode2SessionUrl()
                +"?appid="+weixinProperties.getAppId()
                +"&secret="+weixinProperties.getSecret()
                +"&js_code="+ code +"&grant_type=authorization_code";
        String s = HttpClientUtil.get(jsCode2SessionUrl);
        JSONObject jsonObject = JSON.parseObject(s);
        String openid = jsonObject.get("openid").toString();
        return openid;
    }

    public String getOpenId(User user) throws IOException, ParseException {
        String jsCode2SessionUrl = weixinProperties.getJsCode2SessionUrl()
                +"?appid="+weixinProperties.getAppId()
                +"&secret="+weixinProperties.getSecret()
                +"&js_code="+ user.getCode()+"&grant_type=authorization_code";
        String s = HttpClientUtil.get(jsCode2SessionUrl);
        JSONObject jsonObject = JSON.parseObject(s);
        String openid = jsonObject.get("openid").toString();
        return openid;
    }
}
