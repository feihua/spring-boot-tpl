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
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("操作日志响应vo")
public class OperationLogRespVo implements Serializable {

	@ApiModelProperty(value = "主键")
	private int id;
	@ApiModelProperty(value = "操作者 ID")
	private int userId;
	@ApiModelProperty(value = "操作者姓名")
	private String userName;
	@ApiModelProperty(value = "IP 地址")
	private String ipAddress;
	@ApiModelProperty(value = "操作url")
	private String operationUrl;
	@ApiModelProperty(value = "操作方法")
	private String operationMethod;
	@ApiModelProperty(value = "操作描述")
	private String operationDesc;
	@ApiModelProperty(value = "操作状态")
	private int operationStatus;
	@ApiModelProperty(value = "请求参数")
	private String requestParams;
	@ApiModelProperty(value = "操作结果")
	private String responseParams;
	@ApiModelProperty(value = "异常消息")
	private String errMessage;
	@ApiModelProperty(value = "详细的异常信息")
	private String errMessageDetail;
	@ApiModelProperty(value = "耗时")
	private long useTime;
	@ApiModelProperty(value = "操作时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
}
