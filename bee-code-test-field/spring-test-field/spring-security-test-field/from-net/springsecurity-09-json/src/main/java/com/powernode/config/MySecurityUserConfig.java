package com.powernode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 定义一个bean，用户详情服务接口
 */
@Configuration
public class MySecurityUserConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        //创建了2个用户,系统的用户
        UserDetails user1= User.builder()
                .username("eric")
                .password(passwordEncoder().encode("123456"))
                .roles("student")  //角色的前面加上ROLE_student 就变成了权限
                .build();
        UserDetails user2= User.builder()
                .username("thomas")
                .password(passwordEncoder().encode("123456"))
                .roles("teacher") //ROLE_teacher
                .build();
        InMemoryUserDetailsManager userDetailsService=new InMemoryUserDetailsManager();
        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);

        return userDetailsService;

    }

    /**
     * 自定义用户必须配置密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
