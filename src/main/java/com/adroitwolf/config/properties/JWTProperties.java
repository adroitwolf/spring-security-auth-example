package com.adroitwolf.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName JWTProperties.java
 * @Description
 * jwt 属性类
 * @createTime 2021年02月26日 13:46:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTProperties {
    /**
     * 发行者名
     */
    private String name;

    /**
     * base64加密密钥
     */
    private String base64Secret;

    /**
     * access_token中过期时间设置(s)
     */
    private int jwtExpires;

    /**
     * refresh_token过期时间（day）
     */
    private int refreshExpires;
}
