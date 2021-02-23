package com.adroitwolf.domain.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 9:03
 * Description: ://TODO
 */
@Data
@ToString
public class Usr {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private boolean isEnable;
}
