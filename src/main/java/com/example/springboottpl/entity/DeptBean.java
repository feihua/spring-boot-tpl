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
 * 日期：2024-10-08 17:42:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptBean implements Serializable {
    //部门id
    private Long deptId;
    //租户编号
    private String tenantId;
    //父部门id
    private Long parentId;
    //祖级列表
    private String parentIds;
    //部门名称
    private String deptName;
    //部门类别编码
    private String deptCategory;
    //显示顺序
    private Integer orderNum;
    //负责人
    private Long leader;
    //联系电话
    private String phone;
    //邮箱
    private String email;
    //部门状态(1:正常，0:禁用)
    private Integer status;
    //删除标志（0代表存在 1代表删除）
    private Integer delFlag;
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
