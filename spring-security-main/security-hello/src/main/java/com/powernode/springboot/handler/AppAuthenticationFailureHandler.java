package com.powernode.springboot.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 15:47
 */
@Component
public class AppAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 登录失败返回json数据
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Result result = new Result(-1,"登录失败");
        if(exception instanceof BadCredentialsException) {
            result.setData("用户名或密码错误");
        } else if (exception instanceof DisabledException) {
            result.setData("账户被禁用");
        } else if (exception instanceof UsernameNotFoundException) {
            result.setData("用户名没有找到");
        } else if (exception instanceof CredentialsExpiredException) {
            result.setData("密码已经过期");
        } else if (exception instanceof AccountExpiredException) {
            result.setData("账户已经过期");
        } else if (exception instanceof LockedException) {
            result.setData("账户被锁定");
        } else {
            result.setData("登录失败");
        }


        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();


    }
}
