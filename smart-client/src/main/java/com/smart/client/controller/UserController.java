package com.smart.client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public Authentication getUser(Authentication user){
        return user;
    }

    @RequestMapping("/login")
    public Authentication login(Authentication user){
        return user;
    }
}
