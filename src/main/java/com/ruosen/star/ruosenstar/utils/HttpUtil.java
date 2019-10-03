package com.ruosen.star.ruosenstar.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     HttpUtil   
 *  * @package    com.ruosen.star.ruosenstar.config  
 *  * @author Administrator     
 *  * @date   2019/10/1 0001 星期二
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Component
public class HttpUtil {

    public static String getIpaddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-Ip");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-Ip");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (null != ip && ip.indexOf(".") != -1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
