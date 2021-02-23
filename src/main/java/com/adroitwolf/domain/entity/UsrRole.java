package com.adroitwolf.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 13:47
 * Description: ://TODO 用户角色关联
 */
@Data
@ToString
@AllArgsConstructor
public class UsrRole {
    private Integer id;
    private Integer usrId;
    private Integer rid;

}
