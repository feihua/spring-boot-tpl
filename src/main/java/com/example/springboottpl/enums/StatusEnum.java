package com.example.springboottpl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 描述：角色枚举
 * 作者：刘飞华
 * 日期：2023/4/19 18:05
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

	enable(1, "启用"),
	disable(0, "禁用"),

	;

	private final int code;
	private final String msg;
}
