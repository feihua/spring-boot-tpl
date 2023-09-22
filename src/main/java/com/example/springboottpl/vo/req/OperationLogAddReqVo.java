package com.example.springboottpl.vo.req;

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
@ApiModel("操作日志请求addVo")
public class OperationLogAddReqVo implements Serializable {

	@ApiModelProperty(value = "操作者 ID", required = true)
	@NotNull(message = "userId操作者 ID不能为空")
	private Integer userId;

	@ApiModelProperty(value = "操作者姓名", required = true)
	@NotBlank(message = "userName操作者姓名不能为空")
	private String userName;

	@ApiModelProperty(value = "IP 地址", required = true)
	@NotBlank(message = "ipAddressIP 地址不能为空")
	private String ipAddress;

	@ApiModelProperty(value = "操作url", required = true)
	@NotBlank(message = "operationUrl操作url不能为空")
	private String operationUrl;

	@ApiModelProperty(value = "操作方法", required = true)
	@NotBlank(message = "operationMethod操作方法不能为空")
	private String operationMethod;

	@ApiModelProperty(value = "操作类型", required = true)
	@NotBlank(message = "operationDesc操作类型不能为空")
	private String operationDesc;

	@ApiModelProperty(value = "请求参数", required = true)
	private String requestParams;

	@ApiModelProperty(value = "操作结果", required = true)
	private String responseParams;

	@ApiModelProperty(value = "异常消息")
	private String errMessage;

	@ApiModelProperty(value = "详细的异常信息")
	private String errMessageDetail;

}