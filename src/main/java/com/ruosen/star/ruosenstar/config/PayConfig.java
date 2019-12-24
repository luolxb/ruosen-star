package com.ruosen.star.ruosenstar.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wechat")
@Data
public class PayConfig {

    private String appId;

    private String mchId;

    private String apiKey;

    private String ufdooerUrl;

    private String notifyUrl;

    private String createIp;


}
