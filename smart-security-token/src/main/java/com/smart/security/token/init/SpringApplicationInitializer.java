package com.smart.security.token.init;

import com.smart.security.token.config.ApplicationConfig;
import com.smart.security.token.config.WebConfig;
import com.smart.security.token.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author liujunhua
 * @description: SpringApplicationInitializer相当于web.xml，使用了servlet3.0开发则不需要再定义web.xml，
 * ApplicationConfig.class对应以下配置的application-context.xml，WebConfig.class对应以下配置的springmvc.xml
 * @date 2020/8/1218:02
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring容器，相当于加载 applicationContext.xml
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 指定rootContext的配置类
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }

    /**
     * servletContext，相当于加载springmvc.xml
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 指定servletContext的配置类
        return new Class[]{WebConfig.class};
    }

    /**
     * url-mapping
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
