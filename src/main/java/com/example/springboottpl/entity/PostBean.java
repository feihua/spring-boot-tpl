package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostBean implements Serializable {
    //岗位ID
    private Long postId;
    //租户编号
    private String tenantId;
    //部门id
    private Long deptId;
    //岗位编码
    private String postCode;
    //岗位类别编码
    private String postCategory;
    //岗位名称
    private String postName;
    //显示顺序
    private Integer postSort;
    //状态(1:正常，0:禁用)
    private Integer status;
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
    //修改时间
    private Date updateTime;
}
