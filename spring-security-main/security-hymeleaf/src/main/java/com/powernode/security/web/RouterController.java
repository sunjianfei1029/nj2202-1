package com.powernode.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 15:23
 */
@Controller
public class RouterController {

    @RequestMapping("/index/toIndex")
    public String index() {
        return "main";
    }

    @RequestMapping("/index/toLogin")
    public String toLogin() {
        return "login";
    }

}
