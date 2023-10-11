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
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("菜单信息响应vo")
public class MenuRespVo implements Serializable {

	@ApiModelProperty(value = "主键")
	private int id;
	@ApiModelProperty(value = "菜单名称")
	private String menuName;
	@ApiModelProperty(value = "菜单类型(1：目录   2：菜单   3：按钮)")
	private int menuType;
	@ApiModelProperty(value = "状态(1:正常，0:禁用)")
	private int statusId;
	@ApiModelProperty(value = "排序")
	private int sort;
	@ApiModelProperty(value = "父ID")
	private int parentId;
	@ApiModelProperty(value = "路由路径")
	private String menuUrl;
	@ApiModelProperty(value = "接口URL")
	private String apiUrl;
	@ApiModelProperty(value = "菜单图标")
	private String menuIcon;
	@ApiModelProperty(value = "备注")
	private String remark;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@ApiModelProperty(value = "修改时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
}
