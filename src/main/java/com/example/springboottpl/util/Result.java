package com.example.springboottpl.util;

import lombok.Data;
import static com.example.springboottpl.enums.ExceptionEnum.SUCCESS;

/**
 * 描述：统一返回
 * 作者：刘飞华
 * 日期：2023/2/22 14:12
 */
@Data
public class Result<T> {
	private int code;
	private String msg;
	private boolean success = true;
	private T data;

	public static Result<String> success() {
		Result<String> result = new Result<>();
		result.setCode(SUCCESS.getCode());
		result.setMsg(SUCCESS.getMsg());
		return result;
	}

	public static <T> Result<T> success(T data) {
		Result<T> result = new Result<>();
		result.setCode(SUCCESS.getCode());
		result.setMsg(SUCCESS.getMsg());
		result.setData(data);
		return result;
	}

	public static Result<String> error(int code, String msg) {
		Result<String> result = new Result<>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}