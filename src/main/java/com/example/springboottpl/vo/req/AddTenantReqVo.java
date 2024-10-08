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
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加租户请求Vo")
public class AddTenantReqVo implements Serializable {

    @ApiModelProperty(value = "租户编号", required = true)
    @NotBlank(message = "tenantId租户编号不能为空")
    private String tenantId;
    
    @ApiModelProperty(value = "联系人", required = true)
    @NotBlank(message = "contactUserName联系人不能为空")
    private String contactUserName;
    
    @ApiModelProperty(value = "联系电话", required = true)
    @NotBlank(message = "contactPhone联系电话不能为空")
    private String contactPhone;
    
    @ApiModelProperty(value = "企业名称", required = true)
    @NotBlank(message = "companyName企业名称不能为空")
    private String companyName;
    
    @ApiModelProperty(value = "统一社会信用代码", required = true)
    @NotBlank(message = "licenseNumber统一社会信用代码不能为空")
    private String licenseNumber;
    
    @ApiModelProperty(value = "地址", required = true)
    @NotBlank(message = "address地址不能为空")
    private String address;
    
    @ApiModelProperty(value = "企业简介", required = true)
    @NotBlank(message = "intro企业简介不能为空")
    private String intro;
    
    @ApiModelProperty(value = "域名", required = true)
    @NotBlank(message = "domain域名不能为空")
    private String domain;
    
    @ApiModelProperty(value = "租户套餐编号", required = true)
    @NotNull(message = "packageId租户套餐编号不能为空")
    private Integer packageId;
    
    @ApiModelProperty(value = "过期时间", required = true)
    @NotBlank(message = "expireTime过期时间不能为空")
    private Date expireTime;
    
    @ApiModelProperty(value = "用户数量（-1不限制）", required = true)
    @NotNull(message = "accountCount用户数量（-1不限制）不能为空")
    private Integer accountCount;
    
    @ApiModelProperty(value = "租户状态（0正常 1停用）", required = true)
    @NotBlank(message = "status租户状态（0正常 1停用）不能为空")
    private String status;
    
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", required = true)
    @NotBlank(message = "delFlag删除标志（0代表存在 2代表删除）不能为空")
    private String delFlag;
    
    @ApiModelProperty(value = "备注")
    private String remark;

}