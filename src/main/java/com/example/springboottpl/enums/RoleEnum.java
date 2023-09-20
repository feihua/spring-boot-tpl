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
public enum RoleEnum {

	ADMIN_ROLE(1, "超级管理员!"),

	;

	private final int code;
	private final String msg;
}
