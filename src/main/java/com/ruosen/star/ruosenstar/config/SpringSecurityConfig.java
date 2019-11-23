package com.ruosen.star.ruosenstar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruosen.star.ruosenstar.exception.ValidatorException;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 *  
 *  * @projectName springsecurity
 *  * @title     SpringSecurity   
 *  * @package    com.ruosen.springsecurity.config  
 *  * @author Administrator     
 *  * @date   22019/9/30 0030 星期一
 *  * @version V1.0.0
 *  
 */
@Slf4j
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private ValidatorFilter validatorFilter;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    /**
     * web 请求拦截配置 静态资源
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/connect/**", "/qq**", "/loginServlet/**", "/wclogin/**", "/sendSms/**",
                "/upload/**", "/product/**", "/category/**", "/sysUser/**", "/generate", "/getWeather", "/csrf", "/swagger-resources/**",
                "/v2/api-docs", "/druid/**", "/swagger-ui.html", "/webjars/**", "/css/**", "/js/**", "/img/**", "/vendor/**");
    }

    /**
     * http 请求拦截配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .anyRequest()
                .access("@userService.hasPermission(request)")
                .and()
                .csrf().disable()
                .addFilterBefore(validatorFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .permitAll()
                .failureHandler((request, response, e) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ResponseData responseData = null;
                    if (e instanceof BadCredentialsException ||
                            e instanceof UsernameNotFoundException) {
                        responseData = new ResponseData().error("用户名或密码输入错误");
                    } else if (e instanceof LockedException) {
                        responseData = new ResponseData().error("账号被锁定请联系管理员");
                    } else if (e instanceof CredentialsExpiredException ||
                            e instanceof AccountExpiredException) {
                        responseData = new ResponseData().error("密码过期请联系管理员");
                    } else if (e instanceof DisabledException) {
                        responseData = new ResponseData().error("账号被冻结请联系管理员");
                    } else if (e instanceof ValidatorException) {
                        String msg = ((ValidatorException) e).getMsg();
                        Map<String, Object> dataMap = ((ValidatorException) e).getData();
                        if (!CollectionUtils.isEmpty(dataMap)) {
                            responseData = new ResponseData();
                            responseData.setCode(1100);
                            responseData.setMsg(msg);
                            responseData.setData(dataMap);
                        } else {
                            responseData = new ResponseData().error(msg);
                        }
                    } else {
                        responseData = new ResponseData().error("登录失败,请确认账号信息");
                    }
                    response.setStatus(HttpServletResponse.SC_OK);
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(responseData));
                    out.flush();
                    out.close();
                })
                .successHandler((request, response, auth) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ResponseData responseData = new ResponseData().ok("登录成功");
                    SysUser sysUser = (SysUser) auth.getPrincipal();
                    SysUserVo sysUserVo = new SysUserVo();
                    BeanUtils.copyProperties(sysUser, sysUserVo);
                    responseData.setData(sysUserVo);
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(responseData));
                    out.flush();
                    out.close();
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, e) -> {
                    log.error("SpringSecurityConfig auth failed", e);
                    response.setContentType("application/json;charset=utf-8");
                    ResponseData responseData = new ResponseData().error(HttpServletResponse.SC_FORBIDDEN, "已过期，请重新登录");
                    log.error("auth failed：", responseData.getMsg());
                    response.setHeader("isLogin", "true");
                    PrintWriter out = response.getWriter();
                    out.write(objectMapper.writeValueAsString(responseData));
                    out.flush();
                    out.close();
                }).accessDeniedHandler(authenticationAccessDeniedHandler)
                .and()
                .logout().permitAll().invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and()
                .sessionManagement().maximumSessions(2)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/ssoLogin");
    }

    /**
     * 内存验证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}
