package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleBean implements Serializable {
  //主键
  private int id; 
  //名称
  private String roleName; 
  //状态(1:正常，0:禁用)
  private int statusId; 
  //排序
  private int sort; 
  //备注
  private String remark; 
  //创建时间
  private Date createTime; 
  //修改时间
  private Date updateTime; 
}
