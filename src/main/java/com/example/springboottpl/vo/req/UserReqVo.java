package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel("用户信息请求vo")
public class UserReqVo implements Serializable {

	@ApiModelProperty(value = "主键")
	//@NotBlank(message = "id主键不能为空")
	private int id;

	@ApiModelProperty(value = "手机")
	//@NotBlank(message = "mobile手机不能为空")
	private String mobile;

	@ApiModelProperty(value = "姓名")
	//@NotBlank(message = "userName姓名不能为空")
	private String userName;

	@ApiModelProperty(value = "密码")
	//@NotBlank(message = "password密码不能为空")
	private String password;

	@ApiModelProperty(value = "状态(1:正常，0:禁用)")
	//@NotBlank(message = "statusId状态(1:正常，0:禁用)不能为空")
	private int statusId;

	@ApiModelProperty(value = "排序")
	//@NotBlank(message = "sort排序不能为空")
	private int sort;

	@ApiModelProperty(value = "备注")
	//@NotBlank(message = "remark备注不能为空")
	private String remark;

	@ApiModelProperty(value = "创建时间")
	//@NotBlank(message = "createTime创建时间不能为空")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	//@NotBlank(message = "updateTime修改时间不能为空")
	private Date updateTime;

}
