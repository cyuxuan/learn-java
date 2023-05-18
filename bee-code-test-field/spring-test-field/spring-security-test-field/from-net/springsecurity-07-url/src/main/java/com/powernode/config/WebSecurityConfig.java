package com.powernode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests() //授权请求
                .anyRequest() //任何请求
//                .denyAll();  //拒绝
                .permitAll(); //允许任何请求
        http.formLogin().permitAll(); //允许表单登录 permit：允许
    }
}
