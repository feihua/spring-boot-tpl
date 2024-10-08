package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantPackageBean implements Serializable {
  //租户套餐id
  private Integer packageId; 
  //套餐名称
  private String packageName; 
  //关联菜单id
  private String menuIds; 
  //菜单树选择项是否关联显示
  private Integer menuCheckStrictly; 
  //状态（0正常 1停用）
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
