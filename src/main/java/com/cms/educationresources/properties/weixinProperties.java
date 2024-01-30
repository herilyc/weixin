package com.cms.educationresources.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "weixin")
public class weixinProperties {
    private String jsCode2SessionUrl;
    private String appId;
    private String secret;
}
