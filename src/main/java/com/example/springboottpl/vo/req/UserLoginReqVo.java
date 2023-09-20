package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户登录信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户登录信息请求Vo")
public class UserLoginReqVo implements Serializable {

	@ApiModelProperty(value = "手机", required = true)
	@NotBlank(message = "mobile手机不能为空")
	private String mobile;

	@ApiModelProperty(value = "密码", required = true)
	@NotBlank(message = "password密码不能为空")
	private String password;

}