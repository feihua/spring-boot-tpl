package com.example.springboottpl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 描述：统一返回枚举
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Getter
@AllArgsConstructor
public enum ResponseExceptionEnum {

    SUCCESS("000000", "成功!"),
    INTERNAL_SERVER_ERROR("111111", "服务器内部错误!");

    private final String code;
    private final String msg;
}
