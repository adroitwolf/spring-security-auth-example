package com.adroitwolf.mapper;

import com.adroitwolf.domain.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 13:46
 * Description: ://TODO 角色mapper
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT r.* FROM usr AS u LEFT JOIN role_usr_map AS ru ON u.id = ru.usr_id LEFT JOIN role AS r ON ru.role_id = r.id where u.username =#{username}")
    List<Role> SelectRolesByUsername(String username);
}
