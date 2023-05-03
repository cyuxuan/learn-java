/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.support.config.filter;

import club.beenest.blog.support.common.entity.log.LoginLog;
import club.beenest.blog.entity.user.User;
import club.beenest.blog.support.common.service.log.LoginLogService;
import club.beenest.blog.support.i18n.I18NConstant;
import club.beenest.blog.support.exception.BadRequestException;
import club.beenest.blog.support.request.HttpCode;
import club.beenest.blog.support.request.HttpMethod;
import club.beenest.blog.support.request.Result;
import club.beenest.blog.support.util.IpAddressUtils;
import club.beenest.blog.support.util.JacksonUtils;
import club.beenest.blog.support.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录过滤
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
    /**
     * 记录登录日志
     */
    LoginLogService loginLogService;

    /**
     * 本地线程变量, 当前用户名称
     */
    ThreadLocal<String> currentUsername = new ThreadLocal<>();

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager, LoginLogService loginLogService) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
        this.loginLogService = loginLogService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
        try {
            if (!HttpMethod.REQUEST_METHOD_POST.equals(request.getMethod())) {
                // 请求方法错误
                throw new BadRequestException(I18NConstant.BAD_REQUEST);
            }
            // 获取输入流, 转换为对应对象
            User user = JacksonUtils.readValue(request.getInputStream(), User.class);
            // 当前对象设置到线程本地变量中
            assert user != null;
            currentUsername.set(user.getUsername());
            // 验证当前账号,将账号密码传递给 校验器, 校验器会回调接口实现校验
            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadRequestException exception) {
            response.setContentType("application/json;charset=utf-8");
            Result result = Result.create(HttpCode.HTTP_CODE_ILLEGAL_REQUEST, I18NConstant.ILLEGAL_REQUEST);
            PrintWriter out = response.getWriter();
            out.write(JacksonUtils.writeValueAsString(result));
            out.flush();
            out.close();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {
        String jwt = JwtUtils.generateToken(authResult.getName(), authResult.getAuthorities());
        response.setContentType("application/json;charset=utf-8");
        User user = (User) authResult.getPrincipal();
        user.setPassword(null);
        Map<String, Object> map = new HashMap<>(4);
        map.put("user", user);
        map.put("token", jwt);
        Result result = Result.ok(I18NConstant.LOGIN_SUCCESS, map);
        PrintWriter out = response.getWriter();
        out.write(JacksonUtils.writeValueAsString(result));
        out.flush();
        out.close();
        LoginLog log = handleLog(request, true, I18NConstant.LOGIN_SUCCESS);
        loginLogService.saveLoginLog(log);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException exception) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String msg = exception.getMessage();
        //登录不成功时，会抛出对应的异常
        if (exception instanceof LockedException) {
            // 账号被锁定
            msg = I18NConstant.ACCOUNT_LOCK;
        } else if (exception instanceof CredentialsExpiredException) {
            // 密码过期
            msg = I18NConstant.PASSWORD_EXPIRE;
        } else if (exception instanceof AccountExpiredException) {
            // 账号过期
            msg = I18NConstant.ACCOUNT_EXPIRE;
        } else if (exception instanceof DisabledException) {
            // 账号被禁用
            msg = I18NConstant.ACCOUNT_DISABLE;
        } else if (exception instanceof BadCredentialsException) {
            // 用户名或密码错误
            msg = I18NConstant.ACCOUNT_OR_PASSWORD_ERROR;
        }
        PrintWriter out = response.getWriter();
        out.write(JacksonUtils.writeValueAsString(Result.create(401, msg)));
        out.flush();
        out.close();
        LoginLog log = handleLog(request, false, StringUtils.substring(msg, 0, 50));
        loginLogService.saveLoginLog(log);
    }

    /**
     * 设置LoginLog对象属性
     *
     * @param request     请求对象
     * @param status      登录状态
     * @param description 操作描述
     * @return
     */
    private LoginLog handleLog(HttpServletRequest request, boolean status, String description) {
        String username = currentUsername.get();
        currentUsername.remove();
        String ip = IpAddressUtils.getIpAddress(request);
        String userAgent = request.getHeader("User-Agent");
        LoginLog log = new LoginLog(username, ip, status, description, userAgent);
        return log;
    }
}