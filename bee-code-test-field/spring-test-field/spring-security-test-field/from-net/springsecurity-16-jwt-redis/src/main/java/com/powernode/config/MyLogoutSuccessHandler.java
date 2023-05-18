package com.powernode.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.util.JwtUtils;
import com.powernode.vo.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
@Slf4j
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String auth = request.getHeader("Authorization");
        if (StringUtils.isEmpty(auth)) {
            HttpResult httpResult = HttpResult.builder()
                    .code(0)
                    .msg("jwt 不存在")
                    .build();
            printFront(request, response, httpResult);
            return;
        }
        String jwtToken = auth.replace("bearer ", "");
        boolean result = jwtUtils.verifyToken(jwtToken);
        if (!result) {
            HttpResult httpResult = HttpResult.builder()
                    .code(0)
                    .msg("jwt 非法")
                    .build();
            printFront(request, response, httpResult);
            return;
        }

        //从redis中删除登录成功后放入的jwttoken
        stringRedisTemplate.delete("logintoken:" + jwtToken);
        HttpResult okResult = HttpResult.builder()
                .code(1)
                .msg("退出成功")
                .build();
        printFront(request,response,okResult);

    }

    /**
     * 响应前端
     *
     * @param request
     * @param response
     * @param httpResult
     * @throws IOException
     */
    private void printFront(HttpServletRequest request, HttpServletResponse response, HttpResult httpResult) throws IOException {
        String strResponse = objectMapper.writeValueAsString(httpResult);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(strResponse);
        writer.flush();
    }
}
