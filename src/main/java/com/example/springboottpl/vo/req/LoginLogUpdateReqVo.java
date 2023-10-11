package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@ApiModel("登录日志请求updateVo")
public class LoginLogUpdateReqVo implements Serializable {

	@ApiModelProperty(value = "主键", required = true)
	@NotNull(message = "auditLogId主键不能为空")
	private Integer id;

	@ApiModelProperty(value = "用户ID", required = true)
	@NotNull(message = "userId用户ID不能为空")
	private Integer userId;

	@ApiModelProperty(value = "用户姓名", required = true)
	@NotBlank(message = "userName用户姓名不能为空")
	private String userName;

	@ApiModelProperty(value = "用户IP地址", required = true)
	@NotBlank(message = "ipAddress用户IP地址不能为空")
	private String ipAddress;

}
