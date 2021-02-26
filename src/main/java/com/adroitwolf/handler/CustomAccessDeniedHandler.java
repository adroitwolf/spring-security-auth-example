package com.adroitwolf.handler;

import com.adroitwolf.domain.Dto.BaseResponse;
import com.adroitwolf.utils.ServletUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName CustomAccessDenyFilter.java
 * @Description 如果用户没有权限时，则进入该过滤器
 * @createTime 2021年02月25日 16:32:00
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ServletUtils.render(httpServletRequest,httpServletResponse,new BaseResponse(HttpStatus.FORBIDDEN.value(),"","没有权限嗷"));
    }
}
