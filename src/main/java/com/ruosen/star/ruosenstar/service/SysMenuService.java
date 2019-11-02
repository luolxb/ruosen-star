package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.po.SysMenu;
import com.ruosen.star.ruosenstar.module.vo.SysMenuVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysMenuService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取菜单集合
     *
     * @param name
     * @return
     */
    List<SysMenuVo> getSysMenuList(String name);

    /**
     * 获取权限
     *
     * @param name
     * @return
     */
    List<SysMenuVo> getPermission(String name);
}
