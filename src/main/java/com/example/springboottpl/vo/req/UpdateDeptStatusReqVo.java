package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("更新部门状态请求Vo")
public class UpdateDeptStatusReqVo implements Serializable {

	@ApiModelProperty(value = "主键数组", required = true)
	@NotNull(message = "ids主键不能为空")
	private List<Integer> ids;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "status状态不能为空")
    private Integer status;

}
