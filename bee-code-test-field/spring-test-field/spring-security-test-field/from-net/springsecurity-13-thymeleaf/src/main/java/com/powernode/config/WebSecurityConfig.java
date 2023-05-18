package com.powernode.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //所有请求，都需要认证
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin()
                .loginPage("/toLogin") //配置登录页面
                .usernameParameter("uname") //用户名参数
                .passwordParameter("pwd") //密码参数
                .loginProcessingUrl("/login/doLogin") //单击登录后进入url
                .failureForwardUrl("/toLogin") //登录失败
                .successForwardUrl("/index/toIndex") //登录成功
                .permitAll(); //配置登录
        http.logout().logoutSuccessUrl("/toLogin"); //配置退出成功登录页面

        http.csrf().disable(); //关闭跨域请求保护
    }
}
