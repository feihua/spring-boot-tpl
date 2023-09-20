package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：分配角色菜单
 * 作者：刘飞华
 * 日期：2023/03/28 17:07:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分配角色菜单请求Vo")
public class UpdateRoleMenuListReqVo implements Serializable {

	@ApiModelProperty("角色ID")
	@NotNull(message = "roleId角色ID不能为空")
	private Integer roleId;

	@ApiModelProperty("菜单Ids")
	@NotNull(message = "menuIds不能为空")
	private List<Integer> menuIds;

}