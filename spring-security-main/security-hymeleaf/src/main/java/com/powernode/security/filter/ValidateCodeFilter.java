package com.powernode.security.filter;

import cn.hutool.captcha.LineCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-27 16:03
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       // 处理乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        // 获取请求
        String requestURI = request.getRequestURI();
        if ("/login/doLogin".equals(requestURI)) {
            // 获取sesssion中的验证码 并且根客户端输入的验证码进行比较
            LineCaptcha lineCaptcha = (LineCaptcha) request.getSession().getAttribute("SESSION_KEY_IMAGE_CODE");
            // 获取客户端输入的验证码
            String code = request.getParameter("code");
            boolean verify = lineCaptcha.verify(code);
            if (!verify) {
                response.sendRedirect("/index/toLogin");
                request.getSession().setAttribute("error","验证码错误");
                return;
            } else {
                request.getSession().setAttribute("error","");
            }

        }
        // 放行
        filterChain.doFilter(request, response);
    }
}
