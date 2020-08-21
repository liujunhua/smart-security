package com.smart.security.mvc.session.init;

import com.smart.security.mvc.session.config.ApplicationConfig;
import com.smart.security.mvc.session.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author liujunhua
 * @description: SpringApplicationInitializer
 * @date 2020/8/1218:02
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class};//指定rootContext的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class}; //指定servletContext的配置类
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
