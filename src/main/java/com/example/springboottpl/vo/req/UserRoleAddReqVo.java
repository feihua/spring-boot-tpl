package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色用户关联表请求addVo")
public class UserRoleAddReqVo implements Serializable {

	@ApiModelProperty(value = "主键", required = true)
	//@NotBlank(message = "id主键不能为空")
	private int id;

	@ApiModelProperty(value = "用户ID", required = true)
	//@NotBlank(message = "userId用户ID不能为空")
	private int userId;

	@ApiModelProperty(value = "角色ID", required = true)
	//@NotBlank(message = "roleId角色ID不能为空")
	private int roleId;

	@ApiModelProperty(value = "状态(1:正常，0:禁用)", required = true)
	//@NotBlank(message = "statusId状态(1:正常，0:禁用)不能为空")
	private int statusId;

	@ApiModelProperty(value = "排序", required = true)
	//@NotBlank(message = "sort排序不能为空")
	private int sort;

	@ApiModelProperty(value = "创建时间", required = true)
	//@NotBlank(message = "createTime创建时间不能为空")
	private Date createTime;

	@ApiModelProperty(value = "修改时间", required = true)
	//@NotBlank(message = "updateTime修改时间不能为空")
	private Date updateTime;

}