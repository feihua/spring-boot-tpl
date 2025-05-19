package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "字典数据请求updateVo")
public class UpdateDictDataReqVo implements Serializable {

    @Schema(description = "字典编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "dictCode字典编码不能为空")
    private Long dictCode;

    @Schema(description = "字典排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "dictSort字典排序不能为空")
    private Integer dictSort;

    @Schema(description = "字典标签", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "dictLabel字典标签不能为空")
    private String dictLabel;

    @Schema(description = "字典键值", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "dictValue字典键值不能为空")
    private String dictValue;

    @Schema(description = "字典类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "dictType字典类型不能为空")
    private String dictType;

    @Schema(description = "样式属性（其他样式扩展）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "cssClass样式属性（其他样式扩展）不能为空")
    private String cssClass;

    @Schema(description = "表格回显样式", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "listClass表格回显样式不能为空")
    private String listClass;

    @Schema(description = "是否默认（Y是 N否）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "isDefault是否默认（Y是 N否）不能为空")
    private String isDefault;

    @Schema(description = "状态（0：停用，1:正常）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status状态（0：停用，1:正常）不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}

