package com.ruosen.star.ruosenstar.controller;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.ruosen.star.ruosenstar.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     QQController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/11/23 0023 星期六
 *  * @version V1.0.0
 *  
 */
@Controller
@Slf4j
public class QQController {

    /**
     * 1
     *
     * @return
     */
    @GetMapping("/qqindex")
    public String index() {
        return "qqindex";
    }

    /**
     * 2
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/qqLogin")
    public String QQLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        String authorizeUrl = (new com.qq.connect.oauth.Oauth().getAuthorizeURL(request));
        log.info("url ==> {}", authorizeUrl);
        return "redirect:" + authorizeUrl;
    }

    @GetMapping("/connect")
    public Map<Object, Object> qqConnect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
        // 用户授权的时候取消了
        if (StringUtils.isBlank(accessTokenObj.getAccessToken())) {
            log.error("没有获取到响应参数......");
            throw new CustomException(999, "没有获取到响应参数......");
        }
        String accessToken = accessTokenObj.getAccessToken();
        // 用户QQ的个人信息
        OpenID openIDObj = new OpenID(accessToken);
        // onpenId是QQ用户的唯一标示
        String openID = openIDObj.getUserOpenID();
        //TOKEN
        UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
        UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
        //用户在QQ空间的昵称。
        String nickname = userInfoBean.getNickname();
        String avatar = userInfoBean.getAvatar().getAvatarURL100();
        Integer level = userInfoBean.getLevel();
        String gender = userInfoBean.getGender();
        String msg = userInfoBean.getMsg();
        Integer ret = userInfoBean.getRet();

        Map<Object, Object> map = new HashMap<>();
        map.put(userInfoBean, userInfoBean);
        map.put(nickname, nickname);
        map.put(avatar, avatar);
        map.put(level, level);
        map.put(gender, gender);
        map.put(msg, msg);
        map.put(ret, ret);
        log.info("获取到用户信息 ==> {}", userInfoBean);

        return map;
    }
}