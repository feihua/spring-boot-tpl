package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色信息请求updateVo")
public class RoleUpdateReqVo implements Serializable {

	@ApiModelProperty(value = "主键", required = true)
	@NotNull(message = "id主键不能为空")
	private int id;

	@ApiModelProperty(value = "名称", required = true)
	@NotBlank(message = "roleName名称不能为空")
	private String roleName;

	@ApiModelProperty(value = "状态(1:正常，0:禁用)", required = true)
	@NotNull(message = "statusId状态(1:正常，0:禁用)不能为空")
	private int statusId;

	@ApiModelProperty(value = "排序", required = true)
	@NotNull(message = "sort排序不能为空")
	private int sort;

	@ApiModelProperty(value = "备注")
	private String remark;

}
