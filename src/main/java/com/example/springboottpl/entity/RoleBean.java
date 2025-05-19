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
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleBean implements Serializable {
    //主键
    private Long id;
    //名称
    private String roleName;
    //角色权限字符串
    private String roleKey;
    //数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
    private Integer dataScope;
    //状态(1:正常，0:禁用)
    private Integer status;
    //备注
    private String remark;
    //删除标志（0代表删除 1代表存在）
    private Integer delFlag;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
