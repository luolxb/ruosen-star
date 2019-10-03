package com.ruosen.star.ruosenstar.utils;

import com.ruosen.star.ruosenstar.module.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     RequestHandler   
 *  * @package    com.ruosen.star.ruosenstar.module.base  
 *  * @author Administrator     
 *  * @date   2019/9/30 0030 星期一
 *  * @version V1.0.0
 *  
 */
@Slf4j
public class RequestHandler {

    public static final ThreadLocal<HttpServletRequest> REQUEST_THREAD = new ThreadLocal<>();
    public static final String DEFAULT_USER = "RUOSEN";

    /**
     * 获取当前用户
     *
     * @param request
     */
    public static void add(HttpServletRequest request) {
        REQUEST_THREAD.set(request);
    }

    public static HttpServletRequest getCurrentRequest() {
        return REQUEST_THREAD.get();
    }

    public static void removr() {
        REQUEST_THREAD.remove();
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static SysUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !"anonymousUser".equals(authentication.getPrincipal())) {
            SysUser user = (SysUser) authentication.getPrincipal();
            return user;
        }
        return null;
    }

    public static String getDefaultUserName() {
        SysUser currentUser = getCurrentUser();
        if (currentUser == null) {
            return DEFAULT_USER;
        }
        return currentUser.getUsername();
    }
}
