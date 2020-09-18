package com.smart.security.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1619:16
 */
@Data
@ApiModel(value = "AuthenticationDTO对象", description = "")
public class AuthenticationDTO {

    @ApiModelProperty(value = "应用Id(客户端Id)")
    private String clientId;

    @ApiModelProperty(value = "应用密钥(客户端密钥)")
    private String clientSecret;

    @ApiModelProperty(value = "授权模式：客户模式（grantType=client_credentials）")
    private String grantType;

   /*private String userName;

    private String password;*/

}
