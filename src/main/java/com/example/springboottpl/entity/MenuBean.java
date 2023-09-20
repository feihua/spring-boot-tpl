package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuBean implements Serializable {
  //主键
  private int id; 
  //菜单名称
  private String menuName; 
  //菜单类型(1：目录   2：菜单   3：按钮)
  private int menuType; 
  //状态(1:正常，0:禁用)
  private int statusId; 
  //排序
  private int sort; 
  //父ID
  private int parentId; 
  //路由路径
  private String menuUrl; 
  //接口URL
  private String apiUrl; 
  //菜单图标
  private String menuIcon; 
  //备注
  private String remark; 
  //创建时间
  private Date createTime; 
  //修改时间
  private Date updateTime; 
}
