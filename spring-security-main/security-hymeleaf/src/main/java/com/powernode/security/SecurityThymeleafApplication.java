package com.powernode.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity // 开启Security 如果是5.x以上版本，则默认开启
@MapperScan("com.powernode.security.mapper")
public class SecurityThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityThymeleafApplication.class, args);
    }

}
