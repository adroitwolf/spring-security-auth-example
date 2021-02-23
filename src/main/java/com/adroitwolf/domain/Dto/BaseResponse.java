package com.adroitwolf.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/12 9:48
 * Description: ://TODO 统一JSON构造体
 */
@Data
@AllArgsConstructor
public class BaseResponse {
    private Integer code;
    private Object data;
    private String msg;
}
