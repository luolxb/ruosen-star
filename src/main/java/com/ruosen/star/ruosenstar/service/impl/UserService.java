package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruosen.star.ruosenstar.exception.CustomException;
import com.ruosen.star.ruosenstar.module.Enums.ResultInfoEnum;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.module.vo.SysMenuVo;
import com.ruosen.star.ruosenstar.module.vo.SysRoleVo;
import com.ruosen.star.ruosenstar.service.SysMenuService;
import com.ruosen.star.ruosenstar.service.SysRoleService;
import com.ruosen.star.ruosenstar.service.SysUserService;
import com.ruosen.star.ruosenstar.utils.HttpUtil;
import com.ruosen.star.ruosenstar.utils.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     UserService   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/9/30 0030 星期一
 *  * @version V1.0.0
 *  
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

//    @Value("${server.servlet.context-path}")
//    private String contextPath;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getOne(new QueryWrapper<SysUser>().eq("name", name));
        if (sysUser == null) {
            throw new CustomException(ResultInfoEnum.USER_IS_NOT_EXIST);
        }
        // 获取角色
        List<SysRoleVo> roleVoList = sysRoleService.getSysRoleListByName(name);
        // 获取菜单
        List<SysMenuVo> sysMenuList = sysMenuService.getSysMenuList(name);

        // 获取权限
        List<SysMenuVo> permissions = sysMenuService.getPermission(name);

        Set<String> permissionSet = new HashSet<>();
        permissions.forEach(permission ->
                permissionSet.add(permission.getUrl())
        );
        sysUser.setRoleList(roleVoList);
        sysUser.setPassword(passwordEncoder.encode("123456"));
        sysUser.setPermission(permissionSet);
        sysUser.setMenuList(sysMenuList);
        return sysUser;

    }

    /**
     * 判断请求登录用户是否有权访问URL
     *
     * @param request
     * @return
     */
    public boolean hasPermission(HttpServletRequest request) {
        log.info("请求路径==>{}", request.getRequestURI());
        log.info("请求 IP==>{}", HttpUtil.getIpaddr(RequestHandler.getCurrentRequest()));

        SysUser currentUser = RequestHandler.getCurrentUser();
        if (currentUser != null) {
            log.info("登录人：==>{},{}", currentUser.getUsername(), currentUser.getNickName());
            Set<String> urls = currentUser.getPermission();
            return urls != null && urls.stream().anyMatch(url ->
                    antPathMatcher.match(url, request.getRequestURI()));
        }
        return false;
    }


}
