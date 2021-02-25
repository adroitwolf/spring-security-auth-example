package com.adroitwolf.handler;

import com.adroitwolf.excption.AppException;
import com.adroitwolf.utils.ServletUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName CustomAuthenticationFilter.java
 * @Description 自定义登录过滤器
 * @createTime 2021年02月24日 14:16:00
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
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


        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        this.setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

}
