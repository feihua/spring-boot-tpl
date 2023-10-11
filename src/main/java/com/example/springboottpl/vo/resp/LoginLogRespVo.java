package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@ApiModelProperty(value = "主键")
	private int id;
	@ApiModelProperty(value = "用户ID")
	private int userId;
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	@ApiModelProperty(value = "用户IP地址")
	private String ipAddress;
	@ApiModelProperty(value = "操作时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
}
