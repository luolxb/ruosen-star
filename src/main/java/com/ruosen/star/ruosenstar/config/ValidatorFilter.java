package com.ruosen.star.ruosenstar.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     ValidatorFilter   
 *  * @package    com.ruosen.star.ruosenstar.config  
 *  * @author Administrator     
 *  * @date   2019/9/30 0030 星期一
 *  * @version V1.0.0
 *  
 */
@Data
@Component
@Slf4j
public class ValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "accept,Content-Type,oprumno");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        MDC.put("REQUEST_ID", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
        RequestHandler.add(request);
        doFilter(request, response, filterChain);
    }
}
