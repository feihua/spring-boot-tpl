package com.example.springboottpl.advice;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.UnexpectedTypeException;
import lombok.extern.slf4j.Slf4j;

import com.example.springboottpl.exception.TplException;
import com.example.springboottpl.util.ExceptionUtil;
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
     * @param e   自定义的业务异常
     * @return Result<String>
     * @author 刘飞华
     * @date: 2023/2/22 14:28
     */
    @ExceptionHandler(value = TplException.class)
    @ResponseBody
    public Result<Integer> tplExceptionHandler(HttpServletRequest req, TplException e) {
//        log.error("处理业务异常: {}", ExceptionUtil.stackTrace(e));
        return Result.resp(e.getCode(), e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param req HttpServletRequest
     * @param e   自定义的业务异常
     * @return Result<String>
     * @author 刘飞华
     * @date: 2023/2/22 14:28
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Integer> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("处理其他异常: {}", ExceptionUtil.stackTrace(e));
        return Result.error();
    }

    /**
     * 捕捉全局异常-统一参数校验异常
     *
     * @param e 统一异常类
     * @return Result<String>
     * @author 刘飞华
     * @date: 2023/2/22 14:47
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Integer> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return getStringResult(bindingResult);
    }

    /**
     * 统一参数校验-Hibernate
     *
     * @param e 异常信息
     * @return Result<String>
     * @author 刘飞华
     * @date: 2023/2/22 14:48
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Result<Integer> handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return getStringResult(bindingResult);
    }

    private static Result<Integer> getStringResult(BindingResult bindingResult) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.append(fieldError.getDefaultMessage()).append("!, ");
        }
        return Result.error(errorMessage.toString());
    }

    /**
     * 处理UnexpectedTypeException
     *
     * @param e 异常信息
     * @return Result<String>
     * @author 刘飞华
     * @date: 2023/2/22 14:48
     */
    @ResponseBody
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public Result<Integer> handleUnexpectedTypeException(UnexpectedTypeException e) {
        return Result.error(e.getMessage());
    }
}