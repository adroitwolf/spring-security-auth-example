package com.adroitwolf.handler;

import com.adroitwolf.domain.vo.LoginUser;
import com.adroitwolf.exception.AppException;
import com.adroitwolf.utils.JWTUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName TokenAuthFilter.java
 * @Description 为了了解具体security认证流程，这里不采用jwt，只是仅仅将authen返回这个
 * 过滤器
 * @createTime 2021年02月25日 15:24:00
 */
@Component
public class TokenAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");



        if(token!= null){
            try{
                LoginUser loginUser = JWTUtils.decodeToken(token);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("wolf", null,loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }catch (AppException e){

            }
        }
        filterChain.doFilter(request,httpServletResponse);
    }

}
