package com.ruosen.star.ruosenstar.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.vo.SysUserRq;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.service.SysUserService;
import com.ruosen.star.ruosenstar.utils.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *   系统用户控制层
 *  * @projectName ruosen-star
 *  * @title     SysUserController   
 *  * @package    com.ruosen.star.ruosenstar.controller  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@RestController
@RequestMapping("/sysUser")
@Api(tags = "系统用户")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("/addUser")
    @ApiOperation(value = "新增系统用户")
    public ResponseData addUser(@Valid @RequestBody SysUserRq sysUserRq,
                                BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseData().error(result.getFieldError().getDefaultMessage());
        }
        sysUserService.addUser(sysUserRq);
        return new ResponseData().ok();
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser")
    public ResponseData deleteUser(@RequestParam List<Long> ids) {
        sysUserService.deleteUser(ids);
        return new ResponseData().ok();
    }

    @ApiOperation("修改用户")
    @PutMapping("/updateUser")
    public ResponseData updateUser(@Valid SysUserRq sysUserRq,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseData().error(result.getFieldError().getDefaultMessage());
        }
        sysUserService.updateUser(sysUserRq);
        return new ResponseData().ok();
    }

    @ApiOperation("获取用户详情")
    @GetMapping("detail")
    public ResponseData detail(@RequestParam Long id) {

        SysUserVo sysUserVo = sysUserService.detail(id);
        return new ResponseData().ok(sysUserVo);

    }

    @PostMapping("/getUserPage")
    @ApiOperation(value = "获取用户分页")
    public ResponseData<Page<SysUserVo>> getUserPage(@RequestBody(required = false) SysUserRq sysUserRq,
                                                     PageInfo pageInfo) {
        Page<SysUserVo> sysUserVoPage = sysUserService.selectUserPage(sysUserRq, pageInfo);
        return new ResponseData<>().ok(sysUserVoPage);
    }

    @PostMapping("/getUserList")
    @ApiOperation(value = "获取用集合")
    public ResponseData<List<SysUserVo>> getUserList(@RequestBody(required = false) SysUserRq sysUserRq) {
        List<SysUserVo> sysUserVoPage = sysUserService.selectUserList(sysUserRq);
        return new ResponseData<>().ok(sysUserVoPage);
    }

    /**
     * 清空缓存
     *
     * @return
     */
    @GetMapping("/cacheEvict")
    public ResponseData cacheEvict() {
        return sysUserService.cacheEvict();
    }
}
