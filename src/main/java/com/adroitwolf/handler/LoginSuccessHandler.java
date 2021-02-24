package com.adroitwolf.handler;

import com.adroitwolf.domain.Dto.BaseResponse;
import com.adroitwolf.utils.ServletUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
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
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        ServletUtils.render(httpServletRequest,httpServletResponse,new BaseResponse(HttpStatus.OK.value(),authentication,"登陆成功"));
    }
}
