package com.smart.security.auth.controller;

import com.smart.security.auth.common.AppConstants;
import com.smart.security.auth.dto.AuthenticationDTO;
import com.smart.security.auth.vo.AccessTokenVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.app315.nail.common.result.RichResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1618:56
 */
@RestController
@RequestMapping(value = AppConstants.PATH)
@Api(value = "授权相关接口", tags = "授权端相关接口")
public class AuthenticationController {

    @Value("${security.url}")
    private String securityUrl;

    @PostMapping("oauth/token")
    @ApiOperation(value = "认证")
    public RichResult<AccessTokenVO> oauthToken(@Valid @RequestBody AuthenticationDTO authenticationDTO) {

        MultiValueMap<String, Object> paramsMap = new LinkedMultiValueMap<>();
       /* paramsMap.set("username",authenticationDTO.getUserName());
        paramsMap.set("password",authenticationDTO.getPassword());*/
        paramsMap.set("client_id", authenticationDTO.getClientId());
        paramsMap.set("client_secret", authenticationDTO.getClientSecret());
        paramsMap.set("grant_type", authenticationDTO.getGrantType());
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(authenticationDTO.getClientId(), authenticationDTO.getClientSecret()));
        OAuth2AccessToken token = restTemplate.postForObject(securityUrl + "/oauth/token", paramsMap, OAuth2AccessToken.class);
        AccessTokenVO accessTokenVO = new AccessTokenVO();
        accessTokenVO.setAccessToken(token.getValue());
        accessTokenVO.setTokenType(token.getTokenType());
        accessTokenVO.setExpiresIn(token.getExpiresIn());
        return new RichResult(accessTokenVO);
    }

    @ApiIgnore
    @PostMapping("oauth/token/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "D://";
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

}
