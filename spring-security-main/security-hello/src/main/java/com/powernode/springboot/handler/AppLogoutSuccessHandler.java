package com.powernode.springboot.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 16:15
 */
@Component
public class AppLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Result result = new Result(200, "退出成功", authentication);

        String json = objectMapper.writeValueAsString(result);

        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
