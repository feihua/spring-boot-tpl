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
 * 日期：2023-09-22 09:54:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationLogBean implements Serializable {
  //主键
  private int id; 
  //操作者 ID
  private int userId; 
  //操作者姓名
  private String userName; 
  //IP 地址
  private String ipAddress; 
  //操作url
  private String operationUrl; 
  //操作方法
  private String operationMethod; 
  //操作类型
  private String operationDesc; 
  //请求参数
  private String requestParams; 
  //操作结果
  private String responseParams;
  //异常消息
  private String errMessage;
  //详细的异常信息
  private String errMessageDetail;
  //操作时间
  private Date createTime; 
}
