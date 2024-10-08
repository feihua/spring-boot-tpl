package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询部门列表响应vo")
public class QueryDeptListRespVo implements Serializable {


    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("租户编号")
    private String tenantId;

    @ApiModelProperty("父部门id")
    private Integer parentId;

    @ApiModelProperty("祖级列表")
    private String parentIds;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("部门类别编码")
    private String deptCategory;

    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    @ApiModelProperty("负责人")
    private Integer leader;

    @ApiModelProperty("联系电话")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("部门状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    @ApiModelProperty("创建部门")
    private Integer createDept;

    @ApiModelProperty("创建者")
    private Integer createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新者")
    private Integer updateBy;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
