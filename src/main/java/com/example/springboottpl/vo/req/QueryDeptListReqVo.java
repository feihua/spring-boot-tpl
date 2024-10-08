package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@ApiModel("查询部门列表请求Vo")
public class QueryDeptListReqVo implements Serializable {

    @ApiModelProperty(value = "当前页", required = true, example = "1")
    @NotNull(message = "pageNum当前页不能为空")
    @Min(value=1,message = "pageNum当前页不能小于1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页的数量", required = true, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @ApiModelProperty(value = "租户编号")
    //@NotBlank(message = "tenantId租户编号不能为空")
    private String tenantId;
    @ApiModelProperty(value = "父部门id")
    //@NotBlank(message = "parentId父部门id不能为空")
    private Long parentId;
    @ApiModelProperty(value = "祖级列表")
    //@NotBlank(message = "parentIds祖级列表不能为空")
    private String parentIds;
    @ApiModelProperty(value = "部门名称")
    //@NotBlank(message = "deptName部门名称不能为空")
    private String deptName;
    @ApiModelProperty(value = "部门类别编码")
    //@NotBlank(message = "deptCategory部门类别编码不能为空")
    private String deptCategory;
    @ApiModelProperty(value = "显示顺序")
    //@NotNull(message = "orderNum显示顺序不能为空")
    private Integer orderNum;
    @ApiModelProperty(value = "负责人")
    //@NotBlank(message = "leader负责人不能为空")
    private Long leader;
    @ApiModelProperty(value = "联系电话")
    //@NotBlank(message = "phone联系电话不能为空")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    //@NotBlank(message = "email邮箱不能为空")
    private String email;
    @ApiModelProperty(value = "部门状态(1:正常，0:禁用)")
    //@NotNull(message = "status部门状态(1:正常，0:禁用)不能为空")
    private Integer status;
    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    //@NotNull(message = "delFlag删除标志（0代表存在 1代表删除）不能为空")
    private Integer delFlag;

}
