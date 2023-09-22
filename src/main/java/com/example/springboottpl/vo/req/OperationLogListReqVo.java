package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
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
@ApiModel("操作日志请求listVo")
public class OperationLogListReqVo implements Serializable {

    @ApiModelProperty(value = "当前页", required = true)
    @NotNull(message = "pageNum当前页不能为空")
    @Min(value=1,message = "pageNum当前页不能小于1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页的数量", required = true)
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

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

	@ApiModelProperty(value = "操作类型")
	private String operationDesc;

	@ApiModelProperty(value = "耗时")
	private Integer useTime;
}
