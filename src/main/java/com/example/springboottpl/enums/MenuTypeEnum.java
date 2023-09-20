package com.example.springboottpl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 描述：菜单类型
 * 作者：刘飞华
 * 日期：2023/9/20 17:26
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {

	//菜单类型(1：菜单,2：目录,3：外链,4：按钮)
	menu(1, "菜单"),
	directory(2, "目录"),
	button(3, "按钮"),

	;

	private final int code;
	private final String msg;
}
