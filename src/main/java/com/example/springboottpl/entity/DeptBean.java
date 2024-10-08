package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptBean implements Serializable {
  //部门id
  private Integer deptId; 
  //租户编号
  private String tenantId; 
  //父部门id
  private Integer parentId; 
  //祖级列表
  private String parentIds; 
  //部门名称
  private String deptName; 
  //部门类别编码
  private String deptCategory; 
  //显示顺序
  private Integer orderNum; 
  //负责人
  private Integer leader; 
  //联系电话
  private String phone; 
  //邮箱
  private String email; 
  //部门状态（0正常 1停用）
  private String status; 
  //删除标志（0代表存在 2代表删除）
  private String delFlag; 
  //创建部门
  private Integer createDept; 
  //创建者
  private Integer createBy; 
  //创建时间
  private Date createTime; 
  //更新者
  private Integer updateBy; 
  //更新时间
  private Date updateTime; 
}
