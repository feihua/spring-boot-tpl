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
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询租户详情响应vo")
public class QueryTenantDetailRespVo implements Serializable {


    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("租户编号")
    private String tenantId;

    @ApiModelProperty("联系人")
    private String contactUserName;

    @ApiModelProperty("联系电话")
    private String contactPhone;

    @ApiModelProperty("企业名称")
    private String companyName;

    @ApiModelProperty("统一社会信用代码")
    private String licenseNumber;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("企业简介")
    private String intro;

    @ApiModelProperty("域名")
    private String domain;

    @ApiModelProperty("租户套餐编号")
    private Long packageId;

    @ApiModelProperty("过期时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expireTime;

    @ApiModelProperty("用户数量（-1不限制）")
    private Integer accountCount;

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
