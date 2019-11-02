package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.SysMenuMapper;
import com.ruosen.star.ruosenstar.module.po.SysMenu;
import com.ruosen.star.ruosenstar.module.vo.SysMenuVo;
import com.ruosen.star.ruosenstar.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  菜单服务接口实现类
 *  * @projectName ruosen-star
 *  * @title     SysMenuServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    /**
     * 根据用户名称查询菜单
     *
     * @param name
     * @return
     */
    @Override
    public List<SysMenuVo> getSysMenuList(String name) {
        List<SysMenuVo> sysMenuVoList = this.baseMapper.getSysMenuListByName(name);

        List<SysMenuVo> menuVoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sysMenuVoList)) {
            // 一级菜单
            sysMenuVoList.stream()
                    .filter(sysMenuVo -> StringUtils.isBlank(sysMenuVo.getParentCode()))
                    .forEach(sysMenuVo ->
                            menuVoList.add(sysMenuVo)
                    );
            // 二级菜单
            menuVoList.forEach(menuVo ->
                    menuVo.setChildMenus(getChild(menuVo.getMenuCode(), sysMenuVoList))
            );
        }
        return menuVoList;
    }

    /**
     * 递归子菜单
     *
     * @param menuCode
     * @param rootMenus
     * @return
     */
    private List<SysMenuVo> getChild(String menuCode, List<SysMenuVo> rootMenus) {
        List<SysMenuVo> childList = new ArrayList<>();
        rootMenus
                .stream()
                .filter(rootMenu -> StringUtils.isNotBlank(rootMenu.getParentCode()) &&
                        rootMenu.getParentCode().equals(menuCode))
                .forEach(rootMenu -> childList.add(rootMenu));

        childList.forEach(child ->
                rootMenus.forEach(rootMenu -> {
                    if (child.getMenuCode().equals(rootMenu.getParentCode())) {
                        child.setChildMenus(getChild(child.getMenuCode(), rootMenus));
                    }
                })
        );

        if (CollectionUtils.isEmpty(childList)) {
            return null;
        }
        return childList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysMenuVo> getPermission(String name) {
        return this.baseMapper.getSysMenuListByName(name);
    }
}
