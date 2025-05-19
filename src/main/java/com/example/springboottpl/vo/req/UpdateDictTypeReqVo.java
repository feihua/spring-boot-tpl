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
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "字典类型请求updateVo")
public class UpdateDictTypeReqVo implements Serializable {

    @Schema(description = "字典主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "dictId字典主键不能为空")
    private Long dictId;

    @Schema(description = "字典名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "dictName字典名称不能为空")
    private String dictName;

    @Schema(description = "字典类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "dictType字典类型不能为空")
    private String dictType;

    @Schema(description = "状态（0：停用，1:正常）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status状态（0：停用，1:正常）不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}

