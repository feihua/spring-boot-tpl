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
 * 日期：2024-10-08 17:42:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuBean implements Serializable {
    //主键
    private Long id;
    //菜单名称
    private String menuName;
    //菜单类型(1：目录,2：菜单,3：按钮，4：外链)
    private Integer menuType;
    //状态(1:正常，0:禁用)
    private Integer status;
    //显示状态（0显示 1隐藏）
    private String visible;
    //排序
    private Integer sort;
    //父ID
    private Long parentId;
    //路由路径
    private String menuUrl;
    //接口URL
    private String apiUrl;
    //菜单图标
    private String menuIcon;
    //备注
    private String remark;
    //创建部门
    private Long createDept;
    //创建者
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新者
    private Long updateBy;
    //更新时间
    private Date updateTime;
}
