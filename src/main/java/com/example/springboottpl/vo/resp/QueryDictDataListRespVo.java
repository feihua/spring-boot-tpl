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
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询字典数据列表响应vo")
public class QueryDictDataListRespVo implements Serializable {


    @ApiModelProperty("字典编码")
    private Integer dictCode;

    @ApiModelProperty("租户编号")
    private String tenantId;

    @ApiModelProperty("字典排序")
    private Integer dictSort;

    @ApiModelProperty("字典标签")
    private String dictLabel;

    @ApiModelProperty("字典键值")
    private String dictValue;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("样式属性（其他样式扩展）")
    private String cssClass;

    @ApiModelProperty("表格回显样式")
    private String listClass;

    @ApiModelProperty("是否默认（Y是 N否）")
    private String isDefault;

    @ApiModelProperty("创建部门")
    private Integer createDept;

    @ApiModelProperty("创建者")
    private Integer createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新者")
    private Integer updateBy;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("备注")
    private String remark;


}
