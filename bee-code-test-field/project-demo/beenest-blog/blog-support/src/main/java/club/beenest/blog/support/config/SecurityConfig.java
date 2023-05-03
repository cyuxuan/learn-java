/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.config;

import club.beenest.blog.support.common.service.auth.impl.UserAuthenticationImpl;
import club.beenest.blog.support.config.filter.JwtFilter;
import club.beenest.blog.support.config.filter.JwtLoginFilter;
import club.beenest.blog.support.common.service.log.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Spring Security配置类
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource(type = UserAuthenticationImpl.class, name = "userAuthenticationImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 自定义的校验登录入口
     */
    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 禁用 csrf 防御
            .csrf().disable()
            // 开启跨域支持
            .cors().and()
            // 基于Token，不创建会话
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            // 放行获取网页标题后缀的请求
            .antMatchers("/admin/webTitleSuffix").permitAll()
            // 任何 /admin 开头的路径下的请求都需要经过JWT验证
            .antMatchers(HttpMethod.GET, "/admin/**").hasAnyRole("admin", "visitor")
            .antMatchers("/admin/**").hasRole("admin")
            // 其它路径全部放行
            .anyRequest().permitAll()
            .and()
            // 自定义JWT过滤器
            .addFilterBefore(new JwtLoginFilter("/admin/login", authenticationManager(), loginLogService), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
            // 未登录时，返回json，在前端执行重定向
            .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
    }
}
