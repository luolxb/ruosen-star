package com.ruosen.star.ruosenstar.controller;

import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.vo.SysMenuRq;
import com.ruosen.star.ruosenstar.service.SysMenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysMenuController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@RestController
@RequestMapping("/sysMenu")
@Slf4j
@Api(tags = "菜单")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 获取系统菜单
     *
     * @return
     */
    @PostMapping("/getSysMenu")
    public ResponseData getSysMenu(@RequestBody(required = false) SysMenuRq sysMenuRq) {
        Map<String, Object> map = new HashMap<>();
//        List<SysMenuVo> list = sysMenuService.getSysMenuList(sysMenuRq);
//        map.put("records",list);

        return new ResponseData().ok(map);
    }
}
