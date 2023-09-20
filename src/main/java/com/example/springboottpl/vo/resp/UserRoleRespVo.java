package com.example.springboottpl.vo.resp;

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
@ApiModel("角色用户关联表响应vo")
public class UserRoleRespVo implements Serializable {

	@ApiModelProperty("主键")
	private int id;
	@ApiModelProperty("用户ID")
	private int userId;
	@ApiModelProperty("角色ID")
	private int roleId;
	@ApiModelProperty("状态(1:正常，0:禁用)")
	private int statusId;
	@ApiModelProperty("排序")
	private int sort;
	@ApiModelProperty("创建时间")
	private Date createTime;
	@ApiModelProperty("修改时间")
	private Date updateTime;
}
