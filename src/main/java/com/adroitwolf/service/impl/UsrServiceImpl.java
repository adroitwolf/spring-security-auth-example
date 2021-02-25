package com.adroitwolf.service.impl;

import com.adroitwolf.domain.entity.Role;
import com.adroitwolf.domain.entity.Usr;
import com.adroitwolf.domain.vo.LoginUser;
import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.mapper.UsrMapper;
import com.adroitwolf.service.UsrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<Usr> queryWrapper = new QueryWrapper();
        queryWrapper.ge("username",s);
        Usr usr = usrMapper.selectOne(queryWrapper);
        String pwd = usr.getPassword();
        usr.setPassword(new BCryptPasswordEncoder().encode(pwd));
        if(null == usr){
            throw  new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = roleMapper.SelectRolesByUsername(s);

        Set<String> auth = new HashSet<>();
        roles.stream().forEach(role->{
            auth.add(role.getName());
        });

        LoginUser user = new LoginUser(usr.getUsername(), usr.getPassword(), usr.isEnabled(), auth);

        return user;
    }
}
