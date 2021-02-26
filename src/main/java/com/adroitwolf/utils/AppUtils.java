package com.adroitwolf.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName AppUtils.java
 * @Description app工具类
 * @createTime 2021年02月26日 15:45:00
 */
@Component
public class AppUtils {

    public static Set<GrantedAuthority> buildGrantedAuthority(Set<String> lists){
        Set<GrantedAuthority> authoritiesSet = new HashSet();
        lists.stream().forEach(authoritie->{ //添加权限
            StringBuilder builder = new StringBuilder();
            builder.append("ROLE_");
            builder.append(authoritie);

            GrantedAuthority authority = new SimpleGrantedAuthority(builder.toString());
            authoritiesSet.add(authority);
        });
        return authoritiesSet;
    }

}
