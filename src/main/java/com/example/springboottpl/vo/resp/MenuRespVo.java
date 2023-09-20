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

	@ApiModelProperty("主键")
	private int id;
	@ApiModelProperty("菜单名称")
	private String menuName;
	@ApiModelProperty("菜单类型(1：目录   2：菜单   3：按钮)")
	private int menuType;
	@ApiModelProperty("状态(1:正常，0:禁用)")
	private int statusId;
	@ApiModelProperty("排序")
	private int sort;
	@ApiModelProperty("父ID")
	private int parentId;
	@ApiModelProperty("路由路径")
	private String menuUrl;
	@ApiModelProperty("接口URL")
	private String apiUrl;
	@ApiModelProperty("菜单图标")
	private String menuIcon;
	@ApiModelProperty("备注")
	private String remark;
	@ApiModelProperty("创建时间")
	private Date createTime;
	@ApiModelProperty("修改时间")
	private Date updateTime;
}
