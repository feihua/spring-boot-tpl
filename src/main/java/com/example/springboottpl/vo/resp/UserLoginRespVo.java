package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户信息请求addVo")
public class UserLoginRespVo implements Serializable {

	@ApiModelProperty(value = "主键", required = true)
	private int id;

	@ApiModelProperty(value = "手机", required = true)
	private String mobile;

	@ApiModelProperty(value = "姓名", required = true)
	private String userName;

	@ApiModelProperty(value = "密码", required = true)
	private String token;

}