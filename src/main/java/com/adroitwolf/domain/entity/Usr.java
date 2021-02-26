package com.adroitwolf.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 9:03
 * Description: 用户
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usr {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private boolean isEnabled;



}
