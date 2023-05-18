package com.powernode.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Resource
    private AppAutheticationSuccessHandler appAutheticationSuccessHandler;
    @Resource
    private AppAuthenticationFailHandler appAuthenticationFailHandler;
    @Resource
    private AppLogoutSuccessHanlder appLogoutSuccessHanlder;
    @Resource
    private AppAccessDenyHanlder appAccessDenyHanlder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/student/**")
                .hasRole("student")
                .anyRequest().authenticated();
        //设置登录成功的处理器
        http.formLogin()
                .successHandler(appAutheticationSuccessHandler) //配置认证成功处理器
                .failureHandler(appAuthenticationFailHandler) //配置认证失败处理器
                .permitAll();
        http.logout().logoutSuccessHandler(appLogoutSuccessHanlder);//配置退出成功处理器
        //配置访问拒绝处理器
        http.exceptionHandling().accessDeniedHandler(appAccessDenyHanlder);
    }


}
