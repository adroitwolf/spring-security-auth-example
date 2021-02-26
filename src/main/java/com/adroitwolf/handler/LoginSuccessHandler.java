package com.adroitwolf.handler;

import com.adroitwolf.domain.Dto.BaseResponse;
import com.adroitwolf.domain.vo.LoginUser;
import com.adroitwolf.utils.JWTUtils;
import com.adroitwolf.utils.ServletUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName AuthenSuccessHandler.java
 * @Description 登陆成功返回json
 * @createTime 2021年02月24日 11:16:00
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    // 创建JWT,并返回给用户
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        LoginUser details = (LoginUser) authentication.getDetails();
        LoginUser principal =(LoginUser)  authentication.getPrincipal();
        ServletUtils.render(httpServletRequest,httpServletResponse,new BaseResponse(HttpStatus.OK.value(),JWTUtils.generateToken(principal),"登陆成功"));
    }
}
