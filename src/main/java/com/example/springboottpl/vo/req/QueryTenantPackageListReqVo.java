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
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询租户套餐列表请求Vo")
public class QueryTenantPackageListReqVo implements Serializable {

    @ApiModelProperty(value = "当前页", required = true, example = "1")
    @NotNull(message = "pageNum当前页不能为空")
    @Min(value=1,message = "pageNum当前页不能小于1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页的数量", required = true, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @ApiModelProperty(value = "套餐名称")
    //@NotBlank(message = "packageName套餐名称不能为空")
    private String packageName;
    @ApiModelProperty(value = "关联菜单id")
    //@NotBlank(message = "menuIds关联菜单id不能为空")
    private String menuIds;
    @ApiModelProperty(value = "菜单树选择项是否关联显示")
    //@NotNull(message = "menuCheckStrictly菜单树选择项是否关联显示不能为空")
    private Integer menuCheckStrictly;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    //@NotBlank(message = "status状态（0正常 1停用）不能为空")
    private String status;
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    //@NotBlank(message = "delFlag删除标志（0代表存在 2代表删除）不能为空")
    private String delFlag;
    @ApiModelProperty(value = "备注")
    //@NotBlank(message = "remark备注不能为空")
    private String remark;

}
