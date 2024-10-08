package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantBean implements Serializable {
  //id
  private Integer id; 
  //租户编号
  private String tenantId; 
  //联系人
  private String contactUserName; 
  //联系电话
  private String contactPhone; 
  //企业名称
  private String companyName; 
  //统一社会信用代码
  private String licenseNumber; 
  //地址
  private String address; 
  //企业简介
  private String intro; 
  //域名
  private String domain; 
  //租户套餐编号
  private Integer packageId; 
  //过期时间
  private Date expireTime; 
  //用户数量（-1不限制）
  private Integer accountCount; 
  //租户状态（0正常 1停用）
  private String status; 
  //删除标志（0代表存在 2代表删除）
  private String delFlag; 
  //备注
  private String remark; 
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
