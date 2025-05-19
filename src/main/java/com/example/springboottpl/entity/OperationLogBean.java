package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025-01-17 10:10:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationLogBean implements Serializable {
    //主键
    private Long id;
    //系统模块
    private String title;
    //操作人员
    private Long userId;
    //操作人员
    private String userName;
    //部门id
    private Long deptId;
    //部门名称
    private String deptName;
    //平台信息
    private String platform;
    //操作系统
    private String os;
    //浏览器类型
    private String browser;
    //浏览器版本
    private String version;
    //渲染引擎信息
    private String engine;
    //IP地址
    private String operateIp;
    //请求URL
    private String operationUrl;
    //请求方式
    private String requestMethod;
    //操作描述
    private String operationDesc;
    //操作状态(0:异常,正常)
    private Integer status;
    //请求参数
    private String operateParam;
    //操作结果
    private String jsonResult;
    //异常消息
    private String errorMsg;
    //详细的异常信息
    private String errMsgDetail;
    //耗时
    private Long costTime;
    //操作时间
    private Date operateTime;
}
