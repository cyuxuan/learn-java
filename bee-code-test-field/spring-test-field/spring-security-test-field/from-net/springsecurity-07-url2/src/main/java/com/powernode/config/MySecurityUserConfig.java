package com.powernode.config;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

/**
 * 定义一个bean，用户详情服务接口
 */
@Configuration
public class MySecurityUserConfig  {
    @Bean
    public UserDetailsService userDetailsService(){
        //创建了2个用户,系统的用户
        UserDetails user1= User.builder()
                .username("eric")
                .password(passwordEncoder().encode("123456"))
                .roles("student")  //角色的前面加上ROLE_student 就变成了权限
                .authorities("stduent:delete","student:add") //配置了权限
                .build();
        UserDetails user2= User.builder()
                .username("thomas")
                .password(passwordEncoder().encode("123456"))
                .authorities("teacher:delete","teacher:add") //配置了权限
                .roles("teacher") //ROLE_teacher
                .build();
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
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
