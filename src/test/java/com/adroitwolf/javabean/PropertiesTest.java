package com.adroitwolf.javabean;

import com.adroitwolf.config.properties.JWTProperties;
import com.adroitwolf.domain.vo.LoginUser;
import com.adroitwolf.utils.JWTUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName PropertiesTest.java
 * @Description jwt属性
 * @createTime 2021年02月26日 14:44:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertiesTest {
    @Autowired
    JWTProperties jwtProperties;

    @Autowired
    UserDetailsService usrServiceImpl;

    @Test
    public void jwtTest(){
        LoginUser wolf = (LoginUser)usrServiceImpl.loadUserByUsername("wolf");

        System.out.println(wolf.toString());

        String token = JWTUtils.generateToken(wolf);
        System.out.println(token);
    }
}
