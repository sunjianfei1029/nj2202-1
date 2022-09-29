package com.powernode.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 15:23
 */
@RestController
public class RouterController {

    @PostMapping("/welcome")
    public String index() {
        return "欢迎您来到首页";
    }

    @PostMapping("/fail")
    public String fail() {
        return "登录失败";
    }

}
