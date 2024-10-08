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
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("删除租户套餐请求vo")
public class DeleteTenantPackageReqVo implements Serializable {

	@ApiModelProperty(value = "主键", required = true)
	@NotNull(message = "ids主键不能为空")
	private List<Integer> ids;
}

