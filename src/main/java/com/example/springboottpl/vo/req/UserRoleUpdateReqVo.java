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
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色用户关联表请求updateVo")
public class UserRoleUpdateReqVo implements Serializable {

	@ApiModelProperty(value = "用户ID")
	@NotNull(message = "userId用户ID不能为空")
	private Integer userId;

	@ApiModelProperty(value = "角色IDs")
	@NotNull(message = "roleId角色ID不能为空")
	private List<Integer> roleIds;

}
