package com.example.springboottpl.exception;

import lombok.Data;

import com.example.springboottpl.enums.ExceptionEnum;

@Data
public class TplException extends RuntimeException {
	private int code;

	/**
	 * 服务自定义异常构造方法
	 *
	 * @param exceptionEnum 异常代码
	 * @author 刘飞华
	 * @date: 2023/2/22 14:24
	 */
	public TplException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMsg());
		this.code = exceptionEnum.getCode();
	}

	/**
	 * 服务自定义异常构造方法
	 *
	 * @param code 异常代码
	 * @param message 异常信息
	 * @author 刘飞华
	 * @date 2023/2/22 14:22
	 */
	public TplException(int code, String message) {
		super(message);
		this.code = code;
	}
}
