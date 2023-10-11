package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户菜单
 * 作者：刘飞华
 * 日期：2023/3/29 17:18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户菜单响应vo")
public class UserMenuRespVo implements Serializable {

	@ApiModelProperty(value = "按钮权限")
	private List<String> btnPaths;

	@ApiModelProperty(value = "左侧菜单数据")
	private List<MenuRespVo> leftMenuData;

	@ApiModelProperty(value = "姓名")
	private String name;

	@ApiModelProperty(value = "图像地址")
	private String avatar;

}