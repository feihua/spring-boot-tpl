package com.example.springboottpl.vo.req;

import java.util.List;

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
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色信息请求vo")
public class RoleDeleteReqVo implements Serializable {

	@ApiModelProperty("主键数组")
	private List<Integer> ids;
}

