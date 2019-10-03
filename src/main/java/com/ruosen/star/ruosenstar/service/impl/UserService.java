package com.ruosen.star.ruosenstar.service.impl;

import com.ruosen.star.ruosenstar.config.HttpUtil;
import com.ruosen.star.ruosenstar.config.RequestHandler;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.service.SysUserService;
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
    private PasswordEncoder passwordEncoder;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public UserDetails loadUserByUsername(String userNmae) throws UsernameNotFoundException {
//        SysUser sysUser = sysUserService.selectOne(new EntityWrapper<SysUser>().eq("user_name", userNmae));
////        if (sysUser != null) {
////            // 获取角色
////            // 获取菜单
////
////        }
        Set<String> set = new HashSet<>();
        set.add("/sysUser/getUserList");
        SysUser sysUser = new SysUser();
        sysUser.setName("user1");
        sysUser.setNickName("若森");
        sysUser.setAge(18);
        sysUser.setSex("男");
        sysUser.setId(12L);
        sysUser.setPassword(passwordEncoder.encode("123"));
        sysUser.setPermission(set);
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
