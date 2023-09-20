package com.example.springboottpl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
	SUCCESS(200, "成功!"),
	INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
	TOKEN_NOT_LOGIN(10001, "未登录!"),
	TOKEN_EXPIRE_ERROR(10002, "token已经过期!"),
	TOKEN_FAIL_ERROR(10003, "token验证失败!"),

	USER_PASSWORD_ERROR(20001, "用户名密码错误!"),
	USER_NAME_EXIST_ERROR(20002, "用户名已存在!"),
	USER_NOT_EXIST_ERROR(20003, "用户不存在!"),
	USER_NOT_PASSWORD_ERROR(20004, "原密码错误!"),
	USER_NOT_CONFIRM_PASSWORD_ERROR(20005, "新密码错误!"),

	ADMIN_PERMISSIONS_ERROR(20006, "不能修改超级管理员的权限!"),
	;

	private final int code;
	private final String msg;
}
