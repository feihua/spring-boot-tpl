package com.example.springboottpl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
	SUCCESS(0, "操作成功"),
	ERROR(1, "系统繁忙，请稍后重试"),

	;

	private final int code;
	private final String msg;
}
