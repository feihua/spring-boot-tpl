package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("菜单角色关联表请求listVo")
public class RoleMenuListReqVo implements Serializable {

	@ApiModelProperty(value = "当前页", required = true)
	@NotNull(message = "pageNo当前页不能为空")
	@Min(value = 1, message = "pageNo当前页不能小于1")
	private Integer pageNo;

	@ApiModelProperty(value = "每页的数量", required = true)
	@NotNull(message = "pageSize每页的数量不能为空")
	private Integer pageSize;

	@ApiModelProperty(value = "主键")
	//@NotBlank(message = "id主键不能为空")
	private int id;

	@ApiModelProperty(value = "角色ID")
	//@NotBlank(message = "roleId角色ID不能为空")
	private int roleId;

	@ApiModelProperty(value = "菜单ID")
	//@NotBlank(message = "menuId菜单ID不能为空")
	private int menuId;

	@ApiModelProperty(value = "状态(1:正常，0:禁用)")
	//@NotBlank(message = "statusId状态(1:正常，0:禁用)不能为空")
	private int statusId;

	@ApiModelProperty(value = "排序")
	//@NotBlank(message = "sort排序不能为空")
	private int sort;

	@ApiModelProperty(value = "创建时间")
	//@NotBlank(message = "createTime创建时间不能为空")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	//@NotBlank(message = "updateTime修改时间不能为空")
	private Date updateTime;

}
