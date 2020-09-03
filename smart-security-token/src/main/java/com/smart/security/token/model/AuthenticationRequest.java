package com.smart.security.token.model;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 * 认证请求参数，账号、密码
 **/

@Data
public class AuthenticationRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}