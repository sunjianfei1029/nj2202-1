package com.powernode.springboot.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 14:06
 */
@RestController
@RequestMapping("/user")
public class UserController {



    @GetMapping("/queryUser")
    @PreAuthorize("hasAuthority('user:query')")
    public String queryUser() {
        return "这是一个查询";
    }

    @GetMapping("/addUser")
    @PreAuthorize("hasAuthority('user:add')")
    public String addUser() {
        return "这是一个添加";
    }

    @GetMapping("/deleteUser")
    @PreAuthorize("hasAuthority('user:delete')")
    public String deleteUser() {
        return "这是一个删除";
    }

    @GetMapping("/updateUser")
    @PreAuthorize("hasAuthority('user:update')")
    public String updateUser() {
        return "这是一个更新";
    }

    @GetMapping("/export")
    @PreAuthorize("hasAuthority('user:export')")
    public String expload() {
        return "这是一个导出";
    }

    @GetMapping("/queryAll")
    @PreAuthorize("hasRole('EMP')")
    public String queryAll() {
        return "只能拥有EMP权限的人才能访问";
    }

}
