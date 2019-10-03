package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.module.vo.SysUserRq;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysUserMappper   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
public interface SysUserMappper extends BaseMapper<SysUser> {

    /**
     * 查询用户分页
     *
     * @param sysUserRq
     * @param page
     * @return
     */
    List<SysUserVo> selectUserPage(SysUserRq sysUserRq, Page page);

    List<SysUserVo> selectUserPage(SysUserRq sysUserRq);

}
