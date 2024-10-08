package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogBean implements Serializable {
    //编号
    private Long id;
    //用户名
    private String userName;
    //登录状态
    private String loginStatus;
    //IP地址
    private String ipAddress;
    //浏览器
    private String browser;
    //操作信息
    private String os;
    //登录失败信息
    private String errorMsg;
    //登录时间
    private Date loginTime;
}
