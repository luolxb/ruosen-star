package com.ruosen.star.ruosenstar.config;

import com.alibaba.fastjson.JSON;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     AuthenticationAccessDeniedHandler   
 *  * @package    com.ruosen.star.ruosenstar.config  
 *  * @author Administrator     
 *  * @date   2019/10/2 0002 星期三
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResponseData data = new ResponseData().error("权限不足，请联系管理员");
        log.error("权限不足", e);
        out.write(JSON.toJSONString(data));
        out.flush();
        out.close();

    }
}
