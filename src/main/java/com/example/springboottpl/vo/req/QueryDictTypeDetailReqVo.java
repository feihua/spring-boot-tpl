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
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询字典类型详情请求Vo")
public class QueryDictTypeDetailReqVo implements Serializable {

	@ApiModelProperty(value = "字典主键", required = true)
	@NotNull(message = "dictId字典主键不能为空")
	private Integer dictId;
}
