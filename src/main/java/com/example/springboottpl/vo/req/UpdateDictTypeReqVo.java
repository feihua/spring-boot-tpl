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
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("更新字典类型请求Vo")
public class UpdateDictTypeReqVo implements Serializable {


    @ApiModelProperty(value = "字典主键", required = true)
    @NotBlank(message = "dictId字典主键不能为空")
    private Long dictId;
    
    @ApiModelProperty(value = "租户编号", required = true)
    @NotBlank(message = "tenantId租户编号不能为空")
    private String tenantId;
    
    @ApiModelProperty(value = "字典名称", required = true)
    @NotBlank(message = "dictName字典名称不能为空")
    private String dictName;
    
    @ApiModelProperty(value = "字典类型", required = true)
    @NotBlank(message = "dictType字典类型不能为空")
    private String dictType;
    
    @ApiModelProperty(value = "备注")
    private String remark;

}
