package com.smart.resource.server.common.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:    Swagger2Config 配置功能模块
 * @Author:         xiaoliang.chen
 * @Date:     2019/8/21 上午11:45
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {

    @Bean
    public Docket regulationApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/(hydra-code/).*"))
                .build()
                .apiInfo(apiInfo())
                .enable(true);
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("甲骨文超级码", "http://www.app315.net/", "pubaccount@app315.net");
        return new ApiInfoBuilder()
                .title("码下载")
                .description("码下载相关接口")
                .termsOfServiceUrl("http://www.app315.net/")
                .contact(contact)
                .version("0.1")
                .build();
    }
}