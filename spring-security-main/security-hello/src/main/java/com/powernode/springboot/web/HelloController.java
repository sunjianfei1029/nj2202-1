package com.powernode.springboot.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 10:15
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello Spring Securiry.";
    }

    @GetMapping("/getUserInfo1")
    public Object getUserInfo1(Principal principal) {
        return principal;
    }

    @GetMapping("/getUserInfo2")
    public Object getuserInfo2() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }


}
