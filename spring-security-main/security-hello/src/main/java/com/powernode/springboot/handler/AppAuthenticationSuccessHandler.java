package com.powernode.springboot.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 15:37
 */

@Component
public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 设置json的编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Result result = new Result(200,"登录成功");

        result.setData(authentication);
        // 将处理的结果转成json然后返回
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
