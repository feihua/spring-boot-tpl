package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleBean implements Serializable {
  //主键
  private int id; 
  //用户ID
  private int userId; 
  //角色ID
  private int roleId; 
  //状态(1:正常，0:禁用)
  private int statusId; 
  //排序
  private int sort; 
  //创建时间
  private Date createTime; 
  //修改时间
  private Date updateTime; 
}
