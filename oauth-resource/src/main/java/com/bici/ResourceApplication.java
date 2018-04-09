package com.bici;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: keluosi@bicitech.cn
 * @Date: 2018/4/9 10:38
 * @version: 1.0
 */
@RestController
@SpringBootApplication
@EnableResourceServer
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        System.out.println("resource: user =" + authentication);
        return authentication;
    }
}
