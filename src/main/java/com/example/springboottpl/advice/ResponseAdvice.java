package com.example.springboottpl.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.springboottpl.config.TplConfig;
import com.example.springboottpl.util.Result;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private TplConfig tplConfig;
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 排除已经是 Result 类型的返回值
        if (returnType.getParameterType().equals(Result.class)) {
            return false;
        }

        // 排除特定的 API 路径
        String name = returnType.getDeclaringClass().getName();
        if (name.contains("Swagger")|| name.contains("doc")) {
            return false;
        }

        // 排除特定的注解标记
//        if (returnType.hasMethodAnnotation(IgnoreResponseAdvice.class)) {
//            return false;
//        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // 处理 String 类型特殊情况
        if (body instanceof String) {
            return Result.success(body);
        }
        // 处理其他类型
        return Result.success(body);
    }
}