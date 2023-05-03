/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.config.filter;

import club.beenest.blog.support.i18n.I18NConstant;
import club.beenest.blog.support.request.HttpCode;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.support.util.JacksonUtils;
import club.beenest.blog.support.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * JWT请求过滤器
 * JWT 参考 https://www.jianshu.com/p/d1644e281250
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 后台管理路径外的请求直接跳过
        if (!request.getRequestURI().startsWith(request.getContextPath() + "/admin")) {
            filterChain.doFilter(request, servletResponse);
            return;
        }
        // 获取校验头信息
        String jwt = request.getHeader("Authorization");
        if (JwtUtils.judgeTokenIsExist(jwt)) {
            try {
                // 解析jwt token
                Claims claims = JwtUtils.getTokenBody(jwt);
                // 获取用户名称
                String username = claims.getSubject();
                List<GrantedAuthority> authorities =
                        AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
                // 将token设置到上下文中
                SecurityContextHolder.getContext().setAuthentication(token);
            } catch (Exception e) {
                e.printStackTrace();
                response.setContentType("application/json;charset=utf-8");
                Result result = Result.create(HttpCode.HTTP_CODE_NO_AUTH, I18NConstant.CERTIFICATE_INVALIDATION);
                PrintWriter out = response.getWriter();
                out.write(JacksonUtils.writeValueAsString(result));
                out.flush();
                out.close();
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}