package com.powernode.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.vo.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
@Slf4j
public class AppLogoutSuccessHanlder implements LogoutSuccessHandler {
    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpResult httpResult=HttpResult.builder()
                .code(1)
                .msg("退出成功")
                .build();
        String responseJson = objectMapper.writeValueAsString(httpResult);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(responseJson);
        writer.flush();
    }
}
