package com.adroitwolf.domain.vo;

import com.adroitwolf.domain.entity.Role;
import lombok.Data;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName LoginUser.java
 * @Description 用于spring security构造用的用户角色
 * @createTime 2021年02月24日 09:55:00
 */
@Data

public class LoginUser implements UserDetails {

    private String username;

    private String password;

    private boolean isEnabled;

    private List<Role> roles;

    private Set<GrantedAuthority> authorities;



    public LoginUser(String username, String password, boolean isEnabled, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        Set authoritiesSet = new HashSet();
        authorities.stream().forEach(authoritie->{ //添加权限
            StringBuilder builder = new StringBuilder();
            builder.append("ROLE_");
            builder.append(authoritie);

            GrantedAuthority authority = new SimpleGrantedAuthority(builder.toString());
            authoritiesSet.add(authority);
        });

        this.authorities = authoritiesSet;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
