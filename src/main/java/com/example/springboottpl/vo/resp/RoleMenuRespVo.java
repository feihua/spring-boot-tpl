package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

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
@ApiModel("菜单角色关联表响应vo")
public class RoleMenuRespVo implements Serializable {

	@ApiModelProperty(value = "菜单ID")
	private List<Integer> menuIds;

	@ApiModelProperty(value = "所有菜单")
	private List<MenuRespVo> menuList;
}
