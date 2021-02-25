package com.adroitwolf.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 13:45
 * Description: 数据库角色
 */
@Data
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String nameZh;
}
