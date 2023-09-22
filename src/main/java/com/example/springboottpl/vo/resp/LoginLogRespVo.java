package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel("登录日志响应vo")
public class LoginLogRespVo implements Serializable {

	@ApiModelProperty("主键")
	private int id;
	@ApiModelProperty("用户ID")
	private int userId;
	@ApiModelProperty("用户姓名")
	private String userName;
	@ApiModelProperty("用户IP地址")
	private String ipAddress;
	@ApiModelProperty("操作时间")
	private Date createTime;
}
