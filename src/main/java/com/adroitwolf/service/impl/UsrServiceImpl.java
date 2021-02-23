package com.adroitwolf.service.impl;

import com.adroitwolf.domain.entity.Usr;
import com.adroitwolf.mapper.UsrMapper;
import com.adroitwolf.service.UsrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 9:28
 * Description:
 */
@Service
public class UsrServiceImpl implements UsrService, UserDetailsService {

    @Autowired
    private UsrMapper usrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<Usr> queryWrapper = new QueryWrapper();
        queryWrapper.ge("username",s);
        Usr usr = usrMapper.selectOne(queryWrapper);
        if(null == usr){
            throw  new UsernameNotFoundException("用户不存在");
        }



        return new User();
    }
}
