package com.adroitwolf.handler;

import com.adroitwolf.domain.Dto.BaseResponse;
import com.adroitwolf.utils.ServletUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName LoginFailedHandler.java
 * @Description TODO
 * @createTime 2021年02月25日 08:42:00
 */
@Component
public class LoginFailedHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ServletUtils.render(httpServletRequest,httpServletResponse,new BaseResponse(HttpStatus.OK.value(),e.toString(),"登陆成功"));
    }
}
