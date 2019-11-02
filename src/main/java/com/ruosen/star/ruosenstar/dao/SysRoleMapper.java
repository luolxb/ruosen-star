package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruosen.star.ruosenstar.module.po.SysRole;
import com.ruosen.star.ruosenstar.module.vo.SysRoleVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysRoleMapper   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/10/5 0005 星期六
 *  * @version V1.0.0
 *  
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据名称获取角色
     *
     * @param name
     * @return
     */
    List<SysRoleVo> getsysRoleListByName(String name);
}
