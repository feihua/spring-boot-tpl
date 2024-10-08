package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加字典数据请求Vo")
public class AddDictDataReqVo implements Serializable {

    @ApiModelProperty(value = "租户编号", required = true)
    private String tenantId;
    @ApiModelProperty(value = "字典排序", required = true)
    private Integer dictSort;
    @ApiModelProperty(value = "字典标签", required = true)
    private String dictLabel;
    @ApiModelProperty(value = "字典键值", required = true)
    private String dictValue;
    @ApiModelProperty(value = "字典类型", required = true)
    private String dictType;
    @ApiModelProperty(value = "样式属性（其他样式扩展）", required = true)
    private String cssClass;
    @ApiModelProperty(value = "表格回显样式", required = true)
    private String listClass;
    @ApiModelProperty(value = "是否默认（Y是 N否）", required = true)
    private String isDefault;
    @ApiModelProperty(value = "备注")
    private String remark;

}