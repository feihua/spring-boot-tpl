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
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加租户套餐请求Vo")
public class AddTenantPackageReqVo implements Serializable {

    @ApiModelProperty(value = "套餐名称", required = true)
    @NotBlank(message = "packageName套餐名称不能为空")
    private String packageName;
    
    @ApiModelProperty(value = "关联菜单id")
    private String menuIds;
    
    @ApiModelProperty(value = "菜单树选择项是否关联显示", required = true)
    @NotNull(message = "menuCheckStrictly菜单树选择项是否关联显示不能为空")
    private Integer menuCheckStrictly;
    
    @ApiModelProperty(value = "部门状态(1:正常，0:禁用)", required = true)
    @NotNull(message = "status部门状态(1:正常，0:禁用)不能为空")
    private Integer status;
    
    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）", required = true)
    @NotNull(message = "delFlag删除标志（0代表存在 1代表删除）不能为空")
    private Integer delFlag;
    
    @ApiModelProperty(value = "备注")
    private String remark;

}