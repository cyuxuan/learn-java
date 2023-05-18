package com.powernode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true) //开启全局方法安全，启用预授权注解和后授权注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //controller 的权限配置，可以在这里配置
        http.authorizeRequests().anyRequest().authenticated();//任何请求均需要认证

        http.formLogin().permitAll();  //放开登录页面及登录接口
    }
}
