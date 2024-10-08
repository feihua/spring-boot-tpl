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
@ApiModel("更新字典数据请求Vo")
public class UpdateDictDataReqVo implements Serializable {


    @ApiModelProperty(value = "字典编码", required = true)
    @NotNull(message = "dictCode字典编码不能为空")
    private Integer dictCode;
    
    @ApiModelProperty(value = "租户编号", required = false)
    private String tenantId;
    @ApiModelProperty(value = "字典排序", required = false)
    private Integer dictSort;
    @ApiModelProperty(value = "字典标签", required = false)
    private String dictLabel;
    @ApiModelProperty(value = "字典键值", required = false)
    private String dictValue;
    @ApiModelProperty(value = "字典类型", required = false)
    private String dictType;
    @ApiModelProperty(value = "样式属性（其他样式扩展）", required = false)
    private String cssClass;
    @ApiModelProperty(value = "表格回显样式", required = false)
    private String listClass;
    @ApiModelProperty(value = "是否默认（Y是 N否）", required = false)
    private String isDefault;
    @ApiModelProperty(value = "备注", required = false)
    private String remark;

}
