package com.example.springboottpl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述：自定义注解
 * 作者：刘飞华
 * 日期：2023/9/21 16:06
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {

	/**
	 * 描述业务操作 例:Xxx管理-执行Xxx操作
	 * 支持动态入参，例：新增应用{applicationName}，其中applicationName是请求参数名
	 * @return str
	 * @author 刘飞华
	 * @date: 2023/9/21 16:06
	 */
	String description() default "";
}
