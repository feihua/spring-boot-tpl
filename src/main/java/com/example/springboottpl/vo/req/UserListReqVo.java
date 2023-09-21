package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
@ApiModel("用户信息请求listVo")
public class UserListReqVo implements Serializable {

    @ApiModelProperty(value = "当前页", required = true)
    @NotNull(message = "pageNum当前页不能为空")
    @Min(value=1,message = "pageNum当前页不能小于1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页的数量", required = true)
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

	@ApiModelProperty(value = "手机")
	private String mobile;

	@ApiModelProperty(value = "姓名")
	private String userName;

	@ApiModelProperty(value = "状态(1:正常，0:禁用)")
	private Integer statusId;


}
