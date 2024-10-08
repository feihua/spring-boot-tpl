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
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询租户套餐列表响应vo")
public class QueryTenantPackageListRespVo implements Serializable {


    @ApiModelProperty("租户套餐id")
    private Long packageId;

    @ApiModelProperty("套餐名称")
    private String packageName;

    @ApiModelProperty("关联菜单id")
    private String menuIds;

    @ApiModelProperty("菜单树选择项是否关联显示")
    private Integer menuCheckStrictly;

    @ApiModelProperty("部门状态(1:正常，0:禁用)")
    private Integer status;

    @ApiModelProperty("删除标志（0代表存在 1代表删除）")
    private Integer delFlag;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建部门")
    private Long createDept;

    @ApiModelProperty("创建者")
    private Long createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新者")
    private Long updateBy;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
