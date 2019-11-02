package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.po.SysRole;
import com.ruosen.star.ruosenstar.module.vo.SysRoleVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysRoleService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/10/5 0005 星期六
 *  * @version V1.0.0
 *  
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据名称获取角色
     *
     * @param name
     * @return
     */
    List<SysRoleVo> getSysRoleListByName(String name);

}
