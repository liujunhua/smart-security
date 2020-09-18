package com.smart.security.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/179:40
 */
@Data
@ApiModel(value = "AccessTokenVO对象", description = "")
public class AccessTokenVO {

    @ApiModelProperty(value = "token")
    private String accessToken;

    @ApiModelProperty(value = "token类型")
    private String tokenType;

    @ApiModelProperty(value = "过期时间")
    private int expiresIn;
}
