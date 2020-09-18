package com.smart.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @author liujunhua
 * @description: HydraClientApplication
 * @date 2020/8/1017:17
 */
@EnableOAuth2Sso
@SpringBootApplication
public class SmartClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartClientApplication.class, args);
    }
}
