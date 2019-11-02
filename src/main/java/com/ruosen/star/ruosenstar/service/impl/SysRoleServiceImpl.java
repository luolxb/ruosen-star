package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.SysRoleMapper;
import com.ruosen.star.ruosenstar.module.po.SysRole;
import com.ruosen.star.ruosenstar.module.vo.SysRoleVo;
import com.ruosen.star.ruosenstar.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysRoleServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/5 0005 星期六
 *  * @version V1.0.0
 *  
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    /**
     * 根据名称获取角色
     *
     * @param name
     * @return
     */
    @Override
    public List<SysRoleVo> getSysRoleListByName(String name) {
        return this.baseMapper.getsysRoleListByName(name);
    }
}
