package com.adroitwolf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/9 9:00
 * Description: 项目入口
 */
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.adroitwolf.mapper")
public class SpringApplication {
    public static void main(String args[]){
        org.springframework.boot.SpringApplication.run(SpringApplication.class,args);
    }
}
