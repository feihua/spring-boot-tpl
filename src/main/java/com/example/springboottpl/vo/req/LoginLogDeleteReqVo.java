package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:59:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登录日志请求vo")
public class LoginLogDeleteReqVo implements Serializable {

	@ApiModelProperty(value = "主键数组")
	private List<Integer> ids;
}

