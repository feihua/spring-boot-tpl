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
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询岗位信息列表请求Vo")
public class QueryPostListReqVo implements Serializable {

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
    @ApiModelProperty(value = "部门id")
    //@NotBlank(message = "deptId部门id不能为空")
    private Long deptId;
    @ApiModelProperty(value = "岗位编码")
    //@NotBlank(message = "postCode岗位编码不能为空")
    private String postCode;
    @ApiModelProperty(value = "岗位类别编码")
    //@NotBlank(message = "postCategory岗位类别编码不能为空")
    private String postCategory;
    @ApiModelProperty(value = "岗位名称")
    //@NotBlank(message = "postName岗位名称不能为空")
    private String postName;
    @ApiModelProperty(value = "显示顺序")
    //@NotNull(message = "postSort显示顺序不能为空")
    private Integer postSort;
    @ApiModelProperty(value = "状态(1:正常，0:禁用)")
    //@NotNull(message = "status状态(1:正常，0:禁用)不能为空")
    private Integer status;
    @ApiModelProperty(value = "备注")
    //@NotBlank(message = "remark备注不能为空")
    private String remark;

}
