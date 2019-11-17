package com.ruosen.star.ruosenstar.module.po;

import lombok.Data;

/**
 *  
 *  * @projectName demo
 *  * @title     WeChatToken   
 *  * @package    com.example.demo.controller  
 *  * @author Administrator     
 *  * @date   2019/11/17 0017 星期日
 *  * @version V1.0.0
 *  
 */
@Data
public class WeChatToken {
    /**
     * {
     * "access_token":"ACCESS_TOKEN",
     * "expires_in":7200,
     * "refresh_token":"REFRESH_TOKEN",
     * "openid":"OPENID",
     * "scope":"SCOPE",
     * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
     * }
     */

    private String access_token;
    private Long expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;


}
