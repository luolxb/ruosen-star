package com.ruosen.star.ruosenstar.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     PageController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/9/29 0029 星期日
 *  * @version V1.0.0
 *  
 */
@Controller
@Api(value = "页面跳转控制层")
@Slf4j
public class PageController {

    @GetMapping("/login")
    @ApiOperation("跳转登录页面")
    public String loginPage() {
        log.info("跳转登录页面......");
        return "login.html";
    }

    @PostMapping("/login")
    public void login(@RequestParam String name,
                      @RequestParam String password) {
        log.info("登录用户==>{}", name);
    }
}
