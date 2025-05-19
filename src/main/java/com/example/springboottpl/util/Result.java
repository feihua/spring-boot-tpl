package com.example.springboottpl.util;

import lombok.Data;
import static com.example.springboottpl.enums.ExceptionEnum.ERROR;
import static com.example.springboottpl.enums.ExceptionEnum.SUCCESS;

import com.example.springboottpl.enums.ExceptionEnum;

/**
 * 描述：统一返回
 * 作者：刘飞华
 * 日期：2023/2/22 14:12
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return resp(SUCCESS.getCode(), SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> error() {
        return error(ERROR);
    }

    public static <T> Result<T> error(String msg) {
        return resp(ERROR.getCode(), msg);
    }

    public static <T> Result<T> error(ExceptionEnum anEnum) {
        return resp(anEnum.getCode(), anEnum.getMsg());
    }

    public static <T> Result<T> resp(int code, String msg) {
        return resp(code, msg, null);
    }


    public static <T> Result<T> resp(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

}