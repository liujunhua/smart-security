package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liujunhua
 * @description: 启动类
 * @date 2020/9/1517:07
 */
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    /**
     * 授权码（authorization_code）方式
     * 步骤1 启动应用程序
     * 步骤2 http://localhost:port/oauth/authorize?client_id=dev&response_type=code
     * 步骤3 http://client_id:client_secret@localhost:port/oauth/token 示例 http://dev:123456@localhost:port/oauth/token
     * Content-Type: application/x-www-form-urlencoded
     * request body: grant_type=authorization_code&code=IEeG9I
     *
     */

    /**
     *  简化模式（implicit）
     * 步骤1 启动应用程序
     * 步骤2 http://localhost:port/oauth/authorize?client_id=c1&response_type=token&scope=all&redirect_uri=http://www.baidu.com
     * 步骤3 https://www.baidu.com/#access_token=token&token_type=bearer&expires_in=3599
     * 示例 https://www.baidu.com/#access_token=b7196725-9d4c-4715-89f1-67cef4a3b8b2&token_type=bearer&expires_in=3599
     *
     */

    /**
     *  密码模式（password）
     * 步骤1 启动应用程序
     * 步骤2 POST http://localhost:port/oauth/token?client_id=c1&client_secret=123456&grant_type=password&username=admin&password=123456
     */

    /**
     *  客户端模式（client_credentials）
     * 步骤1 启动应用程序
     * 步骤2 POST http://localhost:port/oauth/token
     * Content-Type: application/x-www-form-urlencoded
     * client_id=c1
     * client_secret=123456
     * grant_type=client_credentials
     */

}
