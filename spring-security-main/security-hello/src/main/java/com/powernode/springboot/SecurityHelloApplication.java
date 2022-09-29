package com.powernode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity // 开启Security 如果是5.x以上版本，则默认开启
public class SecurityHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityHelloApplication.class, args);
    }

}
