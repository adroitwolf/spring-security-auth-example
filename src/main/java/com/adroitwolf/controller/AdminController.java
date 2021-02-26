package com.adroitwolf.controller;

import com.adroitwolf.domain.Dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName AdminController.java
 * @Description 管理员级别可以访问接口
 * @createTime 2021年02月25日 14:49:00
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/test")
    public BaseResponse test(){
        return new BaseResponse(HttpStatus.OK.value(), "","欢迎尊贵的VIP用户");
    }
}
