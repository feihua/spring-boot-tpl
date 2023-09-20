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

	@ApiModelProperty("主键")
	private int id;
	@ApiModelProperty("手机")
	private String mobile;
	@ApiModelProperty("姓名")
	private String userName;
	@ApiModelProperty("密码")
	private String password;
	@ApiModelProperty("状态(1:正常，0:禁用)")
	private int statusId;
	@ApiModelProperty("排序")
	private int sort;
	@ApiModelProperty("备注")
	private String remark;
	@ApiModelProperty("创建时间")
	private Date createTime;
	@ApiModelProperty("修改时间")
	private Date updateTime;
}
