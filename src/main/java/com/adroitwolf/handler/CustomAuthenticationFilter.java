package com.adroitwolf.handler;

import com.adroitwolf.exception.AppException;
import com.adroitwolf.utils.ServletUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName CustomAuthenticationFilter.java
 * @Description 自定义登录过滤器  --> 需要修改
 * @createTime 2021年02月24日 14:16:00
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    //     自定义 provider 列表 --> 已舍弃
//    @Bean
//    DaoAuthenticationProvider daoAuthenticationProvider(){
//
//    }
//
//    @Autowired
//    DaoAuthenticationProvider daoAuthenticationProvider;

    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    //     自定义 provider 列表 --> 已舍弃
//        ProviderManager providerManager = new ProviderManager(Arrays.asList(DaoAuthenticationProvider))

    }

        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;
        try {
            json = ServletUtils.getRequestJsonObject(request);
        } catch (IOException e) {
            throw  new AppException("服务器错误,请重试");
        }

//        获取json值
        String username = json.getString("username");
        String password = json.getString("password");
        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        this.setDetails(request, token);
        return this.getAuthenticationManager().authenticate(token);
    }

}
