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
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantPackageBean implements Serializable {
    //租户套餐id
    private Long packageId;
    //套餐名称
    private String packageName;
    //关联菜单id
    private String menuIds;
    //菜单树选择项是否关联显示
    private Integer menuCheckStrictly;
    //部门状态(1:正常，0:禁用)
    private Integer status;
    //删除标志（0代表存在 1代表删除）
    private Integer delFlag;
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
