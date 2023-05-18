package com.powernode.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // TODO 判断路径 是否是/login/doLogin
        String requestURI = request.getRequestURI();
        if(!requestURI.equals("/login/doLogin")){// 不是登录请求，直接放行
            doFilter(request,response,filterChain); //直接下一个
            return;
        }
        //校验验证码
        validateCode(request,response,filterChain);

    }

    private void validateCode(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //1 从前端获取用户输入的验证码
        String enterCode = request.getParameter("code");
        //2 从session中获取验证码
        String captchaCodeInSession = (String) request.getSession().getAttribute("CAPTCHA_CODE");
        request.getSession().removeAttribute("captcha_code_error"); //清除提示信息
        if(StringUtils.isEmpty(enterCode)){
            request.getSession().setAttribute("captcha_code_error","请输入验证码");
            response.sendRedirect("/toLogin");
            return;
        }
        if(StringUtils.isEmpty(captchaCodeInSession)){
            request.getSession().setAttribute("captcha_code_error","验证码错误");
            response.sendRedirect("/toLogin");
            return;
        }
        //3 判断二者是否相等
        if(!enterCode.equalsIgnoreCase(captchaCodeInSession)){
            request.getSession().setAttribute("captcha_code_error","验证码输入错误");
            response.sendRedirect("/toLogin");
            return;
        }
        request.getSession().removeAttribute("CAPTCHA_CODE"); //删除session中的验证码
        //如果程序执行到这里，说明验证码正确，放行
        this.doFilter(request,response,filterChain);
    }
}
