package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictTypeBean implements Serializable {
  //字典主键
  private Integer dictId; 
  //租户编号
  private String tenantId; 
  //字典名称
  private String dictName; 
  //字典类型
  private String dictType; 
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
