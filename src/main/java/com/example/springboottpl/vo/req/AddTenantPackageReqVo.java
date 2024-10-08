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
 * 日期：2024-10-08 14:26:31
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
    
    @ApiModelProperty(value = "关联菜单id", required = true)
    @NotBlank(message = "menuIds关联菜单id不能为空")
    private String menuIds;
    
    @ApiModelProperty(value = "菜单树选择项是否关联显示", required = true)
    @NotNull(message = "menuCheckStrictly菜单树选择项是否关联显示不能为空")
    private Integer menuCheckStrictly;
    
    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotBlank(message = "status状态（0正常 1停用）不能为空")
    private String status;
    
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", required = true)
    @NotBlank(message = "delFlag删除标志（0代表存在 2代表删除）不能为空")
    private String delFlag;
    
    @ApiModelProperty(value = "备注")
    private String remark;

}