/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.config;

import club.beenest.blog.support.i18n.I18NConstant;
import club.beenest.blog.support.request.HttpCode;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.support.util.JacksonUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未登录时的转向处理
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Result result = Result.create(HttpCode.HTTP_CODE_NO_AUTH, I18NConstant.PLEASE_LOGIN);
        out.write(JacksonUtils.writeValueAsString(result));
        out.flush();
        out.close();
    }
}
