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
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色用户关联表请求addVo")
public class RoleUserAddReq implements Serializable {

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

    @ApiModelProperty("角色ID")
    //@NotNull(message = "roleId角色ID不能为空")
    private long roleId;

    @ApiModelProperty("用户ID")
    //@NotNull(message = "userId用户ID不能为空")
    private long userId;

}