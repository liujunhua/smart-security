package com.smart.resource.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class OrderController {

    @GetMapping(value = "/r/r1")
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限方可访问此url
    public String r1() {
        //获取用户身份信息
        //UserDTO  userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //return userDTO.getFullname()+"访问资源1";
        return "访问资源1";
    }

    @GetMapping(value = "/r/r2")
    //@PreAuthorize("hasAuthority('p2')")//拥有p1权限方可访问此url
    public String r2() {
        //获取用户身份信息
        //UserDTO  userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //return userDTO.getFullname()+"访问资源1";
        return "访问资源2";
    }

}