package com.adroitwolf.domain.vo;

import com.adroitwolf.domain.entity.Role;
import com.adroitwolf.domain.entity.Usr;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2021年02月24日 10:26:00
 */
@Data
@ToString(callSuper = true)
public class User extends Usr {

    private List<Role> roles;
}
