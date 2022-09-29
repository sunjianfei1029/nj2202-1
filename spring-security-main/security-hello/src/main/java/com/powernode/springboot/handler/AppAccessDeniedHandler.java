package com.powernode.springboot.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.springboot.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 16:07
 */
@Component
public class AppAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Result result = new Result(-2,"权限不足");
        result.setData("权限不足");
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();

    }
}
