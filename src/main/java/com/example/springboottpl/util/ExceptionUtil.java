package com.example.springboottpl.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 描述：异常处理
 * 作者：刘飞华
 * 日期：2023/9/21 17:41
 */
public class ExceptionUtil {

	/***
	 * 获取栈信息
	 * @param exception 异常对象
	 * @return 栈追踪的完整信息
	 * @author 刘飞华
	 * @date: 2023/9/21 17:41
	 */
	public static String stackTrace(Exception exception) {
		StringWriter stringWriter = new StringWriter();
		exception.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/***
	 * 获取栈信息
	 * @param exception 异常对象
	 * @return 栈追踪的完整信息
	 * @author 刘飞华
	 * @date: 2023/9/21 17:41
	 */
	public static String stackTrace(Throwable exception) {
		StringWriter stringWriter = new StringWriter();
		exception.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

}
