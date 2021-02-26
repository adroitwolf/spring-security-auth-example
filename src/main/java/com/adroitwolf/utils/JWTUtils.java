package com.adroitwolf.utils;

import com.adroitwolf.config.properties.JWTProperties;
import com.adroitwolf.domain.entity.Role;
import com.adroitwolf.domain.vo.LoginUser;
import com.adroitwolf.domain.vo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName JWTUtils.java
 * @Description JWT工具
 * @createTime 2021年02月26日 13:44:00
 */

@Component
public class JWTUtils {

    public static JWTUtils jwtUtils;

    @Autowired
    public  JWTProperties jwtProperties;

    @PostConstruct
    public void init(){
        jwtUtils = this;
        jwtUtils.jwtProperties = this.jwtProperties;
    }


    /**
     * 生成Token令牌
     * @param user
     * @return
     */
    public static String generateToken(LoginUser user) {
        long currentTimeMillis = System.currentTimeMillis();
        List<String> roles = new ArrayList<>();
        user.getAuthorities().stream().forEach(item->{
            roles.add(item.getAuthority());
        });

        return JWT.create()
                .withIssuer(jwtUtils.jwtProperties.getName())
                .withExpiresAt(new Date(currentTimeMillis + jwtUtils.jwtProperties.getJwtExpires() * 1000))
                .withClaim("userId",user.getUser().getId())
                .withClaim("username",user.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .withAudience(user.getUser().getId().toString(), user.getUser().getEmail())
                .sign(Algorithm.HMAC256(jwtUtils.jwtProperties.getBase64Secret()));
    }

    public static LoginUser decodeToken(String token){

        String username = JWT.decode(token).getClaim("username").asString();
        Integer userId = JWT.decode(token).getClaim("userId").asInt();
        String[] roles = JWT.decode(token).getClaim("roles").asArray(String.class);
        Set auth = new HashSet();
        Arrays.stream(roles).forEach(item->{
            auth.add(new SimpleGrantedAuthority(item));
        });
        LoginUser loginUser = new LoginUser(username,null,true,auth);

        User user = new User();
        user.setId(userId);
        loginUser.setUser(user);
        return loginUser;
    }

    public static JWTVerifier generateVerifier() {
        return JWT.require(Algorithm.HMAC256(jwtUtils.jwtProperties.getBase64Secret()))
                .withIssuer(jwtUtils.jwtProperties.getName())
                .build();

    }

    public static Date generateExpirationDate(String token) {
        return JWT.decode(token).getExpiresAt();
    }



}
