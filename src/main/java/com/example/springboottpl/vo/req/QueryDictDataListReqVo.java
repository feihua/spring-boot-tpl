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
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询字典数据列表请求Vo")
public class QueryDictDataListReqVo implements Serializable {

    @ApiModelProperty(value = "当前页", required = true, example = "1")
    @NotNull(message = "pageNum当前页不能为空")
    @Min(value=1,message = "pageNum当前页不能小于1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页的数量", required = true, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @ApiModelProperty(value = "租户编号")
    //@NotBlank(message = "tenantId租户编号不能为空")
    private String tenantId;
    @ApiModelProperty(value = "字典排序")
    //@NotNull(message = "dictSort字典排序不能为空")
    private Integer dictSort;
    @ApiModelProperty(value = "字典标签")
    //@NotBlank(message = "dictLabel字典标签不能为空")
    private String dictLabel;
    @ApiModelProperty(value = "字典键值")
    //@NotBlank(message = "dictValue字典键值不能为空")
    private String dictValue;
    @ApiModelProperty(value = "字典类型")
    //@NotBlank(message = "dictType字典类型不能为空")
    private String dictType;
    @ApiModelProperty(value = "样式属性（其他样式扩展）")
    //@NotBlank(message = "cssClass样式属性（其他样式扩展）不能为空")
    private String cssClass;
    @ApiModelProperty(value = "表格回显样式")
    //@NotBlank(message = "listClass表格回显样式不能为空")
    private String listClass;
    @ApiModelProperty(value = "是否默认（Y是 N否）")
    //@NotBlank(message = "isDefault是否默认（Y是 N否）不能为空")
    private String isDefault;
    @ApiModelProperty(value = "备注")
    //@NotBlank(message = "remark备注不能为空")
    private String remark;

}
