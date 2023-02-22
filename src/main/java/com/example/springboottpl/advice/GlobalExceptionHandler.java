package com.example.springboottpl.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

import static com.example.springboottpl.enums.ExceptionEnum.INTERNAL_SERVER_ERROR;

import com.example.springboottpl.exception.ApiException;
import com.example.springboottpl.util.Result;

/**
 * 描述：异常统一拦截
 * 作者：刘飞华
 * 日期：2023/2/22 14:00
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 处理自定义的业务异常
	 *
	 * @param req HttpServletRequest
	 * @param e 自定义的业务异常
	 * @return Result<String>
	 * @author 刘飞华
	 * @date: 2023/2/22 14:28
	 */
	@ExceptionHandler(value = ApiException.class)
	@ResponseBody
	public Result<String> apiExceptionHandler(HttpServletRequest req, ApiException e) {
		return Result.error(e.getCode(), e.getMessage());
	}

	/**
	 * 处理其他异常
	 *
	 * @param req HttpServletRequest
	 * @param e 自定义的业务异常
	 * @return Result<String>
	 * @author 刘飞华
	 * @date: 2023/2/22 14:28
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<String> exceptionHandler(HttpServletRequest req, Exception e) {
		return Result.error(INTERNAL_SERVER_ERROR.getCode(), INTERNAL_SERVER_ERROR.getMsg());
	}

	/**
	 * 捕捉全局异常-统一参数校验异常
	 * @param e 统一异常类
	 * @return Result<String>
	 * @author 刘飞华
	 * @date: 2023/2/22 14:47
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		StringBuilder errorMessage = new StringBuilder();
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			errorMessage.append(fieldError.getDefaultMessage()).append("!");
		}
		return Result.error(INTERNAL_SERVER_ERROR.getCode(), errorMessage.toString());
	}

	/**
	 * 统一参数校验-Hibernate
	 * @param e 异常信息
	 * @return Result<String>
	 * @author 刘飞华
	 * @date: 2023/2/22 14:48
	 */
	@ResponseBody
	@ExceptionHandler(value = BindException.class)
	public Result<String> handleBindException(BindException e) {
		BindingResult bindingResult = e.getBindingResult();
		StringBuilder errorMessage = new StringBuilder();
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			errorMessage.append(fieldError.getDefaultMessage()).append("!");
		}
		return Result.error(INTERNAL_SERVER_ERROR.getCode(), errorMessage.toString());
	}
}