package com.adroitwolf.security;

import com.adroitwolf.domain.vo.LoginUser;
import com.adroitwolf.domain.vo.User;
import com.adroitwolf.mapper.UsrMapper;
import com.adroitwolf.service.UsrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/13 11:14
 * Description:  安全测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class securityTest {

    @Test
    public void BcrpytTest(){
        PasswordEncoder pw = new BCryptPasswordEncoder();
        String encode = pw.encode("123");
        System.out.println(encode);
        System.out.println(pw.matches("123",encode));

    }


    @Autowired
    UsrMapper usrMapper;

//    @Test
//    public void mybatisUsrMapperTest(){
//        User wolf = usrMapper.selectOneByName("wolf");
//        System.out.println(wolf);
//    }
    @Autowired
    UserDetailsService usrServiceImpl;


    @Test
    public void loadUserByUsernameTest(){
        LoginUser wolf = (LoginUser)usrServiceImpl.loadUserByUsername("wolf");

        System.out.println(wolf.toString());
    }

}
