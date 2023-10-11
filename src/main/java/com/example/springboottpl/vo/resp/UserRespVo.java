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
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户信息响应vo")
public class UserRespVo implements Serializable {

	@ApiModelProperty(value = "主键")
	private int id;
	@ApiModelProperty(value = "手机")
	private String mobile;
	@ApiModelProperty(value = "姓名")
	private String userName;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "状态(1:正常，0:禁用)")
	private int statusId;
	@ApiModelProperty(value = "排序")
	private int sort;
	@ApiModelProperty(value = "备注")
	private String remark;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@ApiModelProperty(value = "修改时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
}
