package com.adroitwolf.javabean;

import com.adroitwolf.domain.entity.Role;
import com.adroitwolf.domain.entity.Usr;
import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.mapper.UsrMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 9:07
 * Description: ://TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void connectTest(){

        System.out.println("===============");
        List<Role> usrs = roleMapper.selectList(null);

        usrs.stream().forEach(usr -> {
            System.out.println(usr.toString());
        });
    }
}
