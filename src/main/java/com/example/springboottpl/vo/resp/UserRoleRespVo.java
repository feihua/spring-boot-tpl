package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	@ApiModelProperty("角色拥有的角色ids")
	private List<Integer> roleIds;

	@ApiModelProperty("角色拥有的角色")
	private List<RoleRespVo> userRoleList;

	@ApiModelProperty("所有的角色")
	private List<RoleRespVo> allRoleList;
}
