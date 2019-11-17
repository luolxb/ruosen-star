package com.ruosen.star.ruosenstar.controller;

import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.service.SendSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  
 *  * @projectName demo
 *  * @title     SendSmsController   
 *  * @package    com.example.demo.controller  
 *  * @author Administrator     
 *  * @date   2019/11/17 0017 星期日
 *  * @version V1.0.0
 *  
 */
@RestController
@Slf4j
public class SendSmsController {

    @Autowired
    private SendSmsService sendSmsService;

    @GetMapping("/sendSms")
    public ResponseData sendSms(@RequestParam String mobile, HttpSession session) {

        String code = sendSmsService.sendPhoneCode(mobile);
        session.setAttribute(mobile, code);
        session.setMaxInactiveInterval(1000 * 5);

//        Enumeration<String> attributeNames = getSession().getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String element = attributeNames.nextElement();
//            log.info("element ==>{}",element);
//        }
        return new ResponseData<>().ok("success");
    }

    private HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getSession();
    }


}
