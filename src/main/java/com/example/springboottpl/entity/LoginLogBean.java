package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogBean implements Serializable {
    //访问ID
    private Long id;
    //登录账号
    private String loginName;
    //登录IP地址
    private String ipaddr;
    //登录地点
    private String loginLocation;
    //平台信息
    private String platform;
    //浏览器类型
    private String browser;
    //浏览器版本
    private String version;
    //操作系统
    private String os;
    //体系结构信息
    private String arch;
    //渲染引擎信息
    private String engine;
    //渲染引擎详细信息
    private String engineDetails;
    //其他信息（可选）
    private String extra;
    //登录状态(0:失败,1:成功)
    private Integer status;
    //提示消息
    private String msg;
    //访问时间
    private Date loginTime;
}
