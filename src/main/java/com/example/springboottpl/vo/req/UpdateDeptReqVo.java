package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("更新部门请求Vo")
public class UpdateDeptReqVo implements Serializable {


    @ApiModelProperty(value = "部门id", required = true)
    @NotNull(message = "deptId部门id不能为空")
    private Integer deptId;
    
    @ApiModelProperty(value = "租户编号", required = true)
    @NotBlank(message = "tenantId租户编号不能为空")
    private String tenantId;
    
    @ApiModelProperty(value = "父部门id", required = true)
    @NotNull(message = "parentId父部门id不能为空")
    private Integer parentId;
    
    @ApiModelProperty(value = "祖级列表", required = true)
    @NotBlank(message = "parentIds祖级列表不能为空")
    private String parentIds;
    
    @ApiModelProperty(value = "部门名称", required = true)
    @NotBlank(message = "deptName部门名称不能为空")
    private String deptName;
    
    @ApiModelProperty(value = "部门类别编码", required = true)
    @NotBlank(message = "deptCategory部门类别编码不能为空")
    private String deptCategory;
    
    @ApiModelProperty(value = "显示顺序", required = true)
    @NotNull(message = "orderNum显示顺序不能为空")
    private Integer orderNum;
    
    @ApiModelProperty(value = "负责人", required = true)
    @NotNull(message = "leader负责人不能为空")
    private Integer leader;
    
    @ApiModelProperty(value = "联系电话", required = true)
    @NotBlank(message = "phone联系电话不能为空")
    private String phone;
    
    @ApiModelProperty(value = "邮箱", required = true)
    @NotBlank(message = "email邮箱不能为空")
    private String email;
    
    @ApiModelProperty(value = "部门状态（0正常 1停用）", required = true)
    @NotBlank(message = "status部门状态（0正常 1停用）不能为空")
    private String status;
    
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", required = true)
    @NotBlank(message = "delFlag删除标志（0代表存在 2代表删除）不能为空")
    private String delFlag;
    

}
