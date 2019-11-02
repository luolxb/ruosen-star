package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruosen.star.ruosenstar.module.po.SysMenu;
import com.ruosen.star.ruosenstar.module.vo.SysMenuVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysMenuMapper   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取菜单
     *
     * @param name
     * @return
     */
    List<SysMenuVo> getSysMenuListByName(String name);
}
