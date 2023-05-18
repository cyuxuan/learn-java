package com.powernode.config;

import com.powernode.filter.ValidateCodeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private ValidateCodeFilter validateCodeFilter;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //在用户名密码认证过滤器前添加图片验证码过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
        //所有请求，都需要认证
        http.authorizeRequests()
                .mvcMatchers("/code/image")
                .permitAll() //放开验证码的请求
                .anyRequest().authenticated();
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
