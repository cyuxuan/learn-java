package com.powernode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests() //授权请求
//                .regexMatchers("/studnet/**") //不用学
//                .antMatchers("/student/**")  // 不用学
                .mvcMatchers("/student/**") //匹配这个url
                .hasAnyAuthority("student:add") //拥有这个权限的用户可以访问的/student/**
                .mvcMatchers("/teacher/**") //匹配url
                .hasAuthority("ROLE_teacher") //拥有这个权限的用户可以访问的/teacher/**
                .anyRequest() //任何请求
                .authenticated(); //都需要登录 ,注意：没有配置mvc的只要登录成功就可以访问
        http.formLogin().permitAll(); //允许表单登录 permit：允许
    }
}
