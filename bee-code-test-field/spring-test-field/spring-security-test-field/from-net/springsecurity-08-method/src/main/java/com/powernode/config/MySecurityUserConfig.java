package com.powernode.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Slf4j
public class MySecurityUserConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        //新建用户
        UserDetails user1= User.builder()
                .username("eric")
                .password(passwordEncoder().encode("123456")) //用户密码必须加密
                .roles("student") //角色  转变成权限(ROLE_student)
                .build();
        UserDetails user2= User.builder()
                .username("thomas")
                .password(passwordEncoder().encode("123456")) //用户密码必须加密
                .authorities("teacher:query")
                .build();
        UserDetails user3= User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456")) //用户密码必须加密
                .authorities("teacher:query","teacher:add","teacher:update","teacher:delete")
                .build();

        InMemoryUserDetailsManager userDetailsService =new InMemoryUserDetailsManager();
        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);
        userDetailsService.createUser(user3);
        return  userDetailsService;

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
