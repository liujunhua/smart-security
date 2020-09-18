package com.smart.security.auth.controller;

import com.smart.security.auth.common.AppConstants;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.sql.DataSource;

/**
 * @author liujunhua
 * @description: ClientController
 * @date 2020/8/1113:52
 */
@ApiIgnore
@RestController
@RequestMapping(value = AppConstants.PATH + "/client")
@Api(value = "客户端相关接口", tags = "客户端相关接口")
public class ClientController {

    @Autowired
    private DataSource dataSource;

    @PostMapping
    public void add(BaseClientDetails clientDetails) throws ClientAlreadyExistsException {
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.addClientDetails(clientDetails);
    }
}
