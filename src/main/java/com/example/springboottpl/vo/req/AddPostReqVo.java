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
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加岗位信息请求Vo")
public class AddPostReqVo implements Serializable {

    @ApiModelProperty(value = "租户编号", required = true)
    @NotBlank(message = "tenantId租户编号不能为空")
    private String tenantId;
    
    @ApiModelProperty(value = "部门id", required = true)
    @NotNull(message = "deptId部门id不能为空")
    private Integer deptId;
    
    @ApiModelProperty(value = "岗位编码", required = true)
    @NotBlank(message = "postCode岗位编码不能为空")
    private String postCode;
    
    @ApiModelProperty(value = "岗位类别编码", required = true)
    @NotBlank(message = "postCategory岗位类别编码不能为空")
    private String postCategory;
    
    @ApiModelProperty(value = "岗位名称", required = true)
    @NotBlank(message = "postName岗位名称不能为空")
    private String postName;
    
    @ApiModelProperty(value = "显示顺序", required = true)
    @NotNull(message = "postSort显示顺序不能为空")
    private Integer postSort;
    
    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotBlank(message = "status状态（0正常 1停用）不能为空")
    private String status;
    
    @ApiModelProperty(value = "备注")
    private String remark;

}