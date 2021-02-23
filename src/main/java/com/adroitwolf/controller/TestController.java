package com.adroitwolf.controller;

import com.adroitwolf.domain.Dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/11 15:25
 * Description: ://TODO ${END}
 */
@RestController
public class TestController {

    @ApiOperation("测试模块")
    @GetMapping("/hello/{user}")
    public String hello(@PathVariable("user")String user){
        return "欢迎这个狗闸种嗷@" + user ;
    }


    @ApiOperation("登陆")
    @PostMapping("/loginUsr")
    public BaseResponse login(@RequestBody Map<String,String> params){
        return 
    }
}
