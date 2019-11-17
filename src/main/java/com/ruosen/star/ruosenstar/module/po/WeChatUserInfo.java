package com.ruosen.star.ruosenstar.module.po;

import lombok.Data;

import java.util.List;

/**
 *  
 *  * @projectName demo
 *  * @title     WeChatUserInfo   
 *  * @package    com.example.demo.controller  
 *  * @author Administrator     
 *  * @date   2019/11/17 0017 星期日
 *  * @version V1.0.0
 *  
 */
@Data
public class WeChatUserInfo {

    /**
     * {
     * "openid":"OPENID",
     * "nickname":"NICKNAME",
     * "sex":1,
     * "province":"PROVINCE",
     * "city":"CITY",
     * "country":"COUNTRY",
     * "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
     * "privilege":[
     * "PRIVILEGE1",
     * "PRIVILEGE2"
     * ],
     * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
     * <p>
     * }
     */
    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private List<String> privilege;
    private String unionid;


}
