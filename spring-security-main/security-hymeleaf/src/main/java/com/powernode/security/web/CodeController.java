package com.powernode.security.web;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-27 15:51
 */

@Controller
public class CodeController {

    @RequestMapping("/code/image")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // width: height 验证码的宽和高 codeCount: 验证的长度 lineCount: 设置干扰现的个数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(50, 50, 1, 20);
        request.getSession().setAttribute("SESSION_KEY_IMAGE_CODE",lineCaptcha);
        lineCaptcha.write(response.getOutputStream());


    }
}
