package com.ruosen.star.ruosenstar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruosen.star.ruosenstar.module.po.WeChatToken;
import com.ruosen.star.ruosenstar.module.po.WeChatUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 *  
 *  * @projectName demo
 *  * @title     wechatController   
 *  * @package    com.example.demo.controller  
 *  * @author Administrator     
 *  * @date   2019/11/17 0017 星期日
 *  * @version V1.0.0
 *  
 */
@Controller
@Slf4j
public class WechatController {

    private static final String appId = "wx7287a60bb700fd21";
    private static final String secret = "1ef8755f92bebae8ab7bab432ba29cbf";
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/wclogin")
    public String wclogin() {

        return "wclogin";
    }

    @GetMapping("/loginServlet")
    @ResponseBody
    public Object loginwechat(@RequestParam String code,
                              @RequestParam String state) {
        log.info("loginwechat code:{},state:{}", code, state);
        // 若用户禁止授权，则重定向后不会带上code参数，仅会带上state参数
        if (code == null) {
            throw new RuntimeException("户禁止授权...");
        }
        // 获取token
        // https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String token = restTemplate.getForObject(tokenUrl, String.class);
        log.info("token ==>{}", token);
        WeChatToken weChatToken = null;
        try {
            weChatToken = objectMapper.readValue(token, WeChatToken.class);
        } catch (Exception e) {
            log.error("objectMapper String -> weChatToken error", e);
            throw new RuntimeException("微信扫码异常...");
        }

        // 获取个人信息  https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
        String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + weChatToken.getAccess_token() + "&openid=" + weChatToken.getOpenid() + "";
        String userInfo = restTemplate.getForObject(userInfoUrl, String.class);
        log.info("userInfo ==>{}", userInfo);

        WeChatUserInfo weChatUserInfo = null;
        try {
            weChatUserInfo = objectMapper.readValue(userInfo, WeChatUserInfo.class);
        } catch (Exception e) {
            log.error("objectMapper String -> weChatUserInfo error", e);
            throw new RuntimeException("获取用户信息异常...");
        }
        log.info("weChatUserInfo ==>{}", weChatUserInfo);
        return "ok";
    }
}
