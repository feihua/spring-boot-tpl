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
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色信息请求updateVo")
public class RoleUpdateReq implements Serializable {

    @ApiModelProperty("主键")
    //@NotNull(message = "id主键不能为空")
    private long id;

    @ApiModelProperty("创建时间")
    //@NotNull(message = "gmtCreate创建时间不能为空")
    private Date gmtCreate;

    @ApiModelProperty("修改时间")
    //@NotNull(message = "gmtModified修改时间不能为空")
    private Date gmtModified;

    @ApiModelProperty("状态(1:正常，0:禁用)")
    //@NotNull(message = "statusId状态(1:正常，0:禁用)不能为空")
    private short statusId;

    @ApiModelProperty("排序")
    //@NotNull(message = "sort排序不能为空")
    private int sort;

    @ApiModelProperty("名称")
    //@NotNull(message = "roleName名称不能为空")
    private String roleName;

    @ApiModelProperty("备注")
    //@NotNull(message = "remark备注不能为空")
    private String remark;

}