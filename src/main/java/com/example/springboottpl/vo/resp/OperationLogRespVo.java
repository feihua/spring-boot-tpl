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

	@ApiModelProperty("主键")
	private int id;
	@ApiModelProperty("操作者 ID")
	private int userId;
	@ApiModelProperty("操作者姓名")
	private String userName;
	@ApiModelProperty("IP 地址")
	private String ipAddress;
	@ApiModelProperty("操作url")
	private String operationUrl;
	@ApiModelProperty("操作方法")
	private String operationMethod;
	@ApiModelProperty("操作类型")
	private String operationDesc;
	@ApiModelProperty("请求参数")
	private String requestParams;
	@ApiModelProperty("操作结果")
	private String responseParams;
	@ApiModelProperty(value = "异常消息")
	private String errMessage;
	@ApiModelProperty(value = "详细的异常信息")
	private String errMessageDetail;
	@ApiModelProperty(value = "耗时")
	private long useTime;
	@ApiModelProperty("操作时间")
	private Date createTime;
}
