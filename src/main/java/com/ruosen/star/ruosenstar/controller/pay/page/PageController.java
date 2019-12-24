package com.ruosen.star.ruosenstar.controller.pay.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
@Slf4j
public class PageController {

    /**
     * 路径跳转
     *
     * @param url
     * @return
     */
    @GetMapping("/{url}")
    public String page(@PathVariable String url) {
        log.info("url==>{}",url);
        return url;
    }
}
