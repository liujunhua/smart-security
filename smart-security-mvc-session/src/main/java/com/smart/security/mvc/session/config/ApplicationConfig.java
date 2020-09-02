package com.smart.security.mvc.session.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author liujunhua
 * @description: ApplicationConfig 它对应web.xml中ContextLoaderListener的配置
 * @date 2020/8/1217:55
 */
@Configuration //相当于applicationContext.xml
@ComponentScan(basePackages = "com.smart.security.mvc.session"
        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
