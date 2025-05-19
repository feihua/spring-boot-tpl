package com.example.tpl.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptBean implements Serializable {
    //部门id
    private Long id;
    //父部门id
    private Long parentId;
    //祖级列表
    private String ancestors;
    //部门名称
    private String deptName;
    //显示顺序
    private Integer sort;
    //负责人
    private String leader;
    //联系电话
    private String phone;
    //邮箱
    private String email;
    //部门状态（0：停用，1:正常）
    private Integer status;
    //删除标志（0代表删除 1代表存在）
    private Integer delFlag;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
