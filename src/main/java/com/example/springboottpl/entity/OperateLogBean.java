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
 * 日期：2024-10-08 17:42:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperateLogBean implements Serializable {
    //编号
    private Long id;
    //系统模块
    private String title;
    //操作类型
    private String operationType;
    //操作人员
    private String operationName;
    //请求方式
    private String requestMethod;
    //操作方法
    private String operationUrl;
    //请求参数
    private String operationParams;
    //响应参数
    private String operationResponse;
    //操作状态
    private Integer operationStatus;
    //部门名称
    private String deptName;
    //执行时长(毫秒)
    private Long useTime;
    //浏览器
    private String browser;
    //操作信息
    private String os;
    //操作地址
    private String operationIp;
    //操作时间
    private Date operationTime;
}
