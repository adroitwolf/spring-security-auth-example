package com.adroitwolf.security;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/13 11:14
 * Description: ://TODO 安全测试
 */
@SpringBootTest
public class securityTest {

    @Test
    public void BcrpytTest(){
        PasswordEncoder pw = new BCryptPasswordEncoder();
        String encode = pw.encode("123");
        System.out.println(encode);
        System.out.println(pw.matches("123",encode));

    }
}
