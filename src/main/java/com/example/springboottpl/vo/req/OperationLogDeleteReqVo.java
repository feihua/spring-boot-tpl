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
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("操作日志请求vo")
public class OperationLogDeleteReqVo implements Serializable {

	@ApiModelProperty("主键数组")
	private List<Integer> ids;
}

