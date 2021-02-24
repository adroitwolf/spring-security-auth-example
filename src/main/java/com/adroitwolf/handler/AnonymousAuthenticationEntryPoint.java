package com.adroitwolf.handler;

import com.adroitwolf.domain.Dto.BaseResponse;
import com.adroitwolf.utils.ServletUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName AnonymousAuthenticationEntryPoint.java
 * @Description 如果未登录，会进入到这个过滤器中
 * @createTime 2021年02月24日 13:20:00
 */
@Component
public class AnonymousAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ServletUtils.render(httpServletRequest,httpServletResponse,new BaseResponse(HttpStatus.UNAUTHORIZED.value(),"","请登录"));
    }
}
