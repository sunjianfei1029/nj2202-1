package com.powernode.security.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 14:06
 */
@Controller
@RequestMapping("/user")
public class UserController {



    @GetMapping("/query")
    @PreAuthorize("hasAuthority('user:query')")
    public String queryUser() {
        return "/user/query";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('user:add')")
    public String addUser() {
        return "/user/add";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('user:delete')")
    public String deleteUser() {
        return "/user/delete";
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('user:update')")
    public String updateUser() {
        return "/user/update";
    }

    @GetMapping("/export")
    @PreAuthorize("hasAuthority('user:export')")
    public String expload() {
        return "/user/export";
    }

}
