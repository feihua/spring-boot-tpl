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
 * 日期：2023-09-22 09:59:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogBean implements Serializable {
  //主键
  private int id; 
  //用户ID
  private int userId; 
  //用户姓名
  private String userName; 
  //用户IP地址
  private String ipAddress; 
  //操作时间
  private Date createTime; 
}
