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
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("菜单信息请求addVo")
public class MenuAddReqVo implements Serializable {

	@ApiModelProperty(value = "主键", required = true)
	//@NotBlank(message = "id主键不能为空")
	private int id;

	@ApiModelProperty(value = "菜单名称", required = true)
	//@NotBlank(message = "menuName菜单名称不能为空")
	private String menuName;

	@ApiModelProperty(value = "菜单类型(1：目录   2：菜单   3：按钮)", required = true)
	//@NotBlank(message = "menuType菜单类型(1：目录   2：菜单   3：按钮)不能为空")
	private int menuType;

	@ApiModelProperty(value = "状态(1:正常，0:禁用)", required = true)
	//@NotBlank(message = "statusId状态(1:正常，0:禁用)不能为空")
	private int statusId;

	@ApiModelProperty(value = "排序", required = true)
	//@NotBlank(message = "sort排序不能为空")
	private int sort;

	@ApiModelProperty(value = "父ID", required = true)
	//@NotBlank(message = "parentId父ID不能为空")
	private int parentId;

	@ApiModelProperty(value = "路由路径", required = true)
	//@NotBlank(message = "menuUrl路由路径不能为空")
	private String menuUrl;

	@ApiModelProperty(value = "接口URL", required = true)
	//@NotBlank(message = "apiUrl接口URL不能为空")
	private String apiUrl;

	@ApiModelProperty(value = "菜单图标", required = true)
	//@NotBlank(message = "menuIcon菜单图标不能为空")
	private String menuIcon;

	@ApiModelProperty(value = "备注", required = true)
	//@NotBlank(message = "remark备注不能为空")
	private String remark;

	@ApiModelProperty(value = "创建时间", required = true)
	//@NotBlank(message = "createTime创建时间不能为空")
	private Date createTime;

	@ApiModelProperty(value = "修改时间", required = true)
	//@NotBlank(message = "updateTime修改时间不能为空")
	private Date updateTime;

}