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
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "岗位信息请求updateVo")
public class UpdatePostReqVo implements Serializable {

    @Schema(description = "岗位id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id岗位id不能为空")
    private Long id;

    @Schema(description = "岗位编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "postCode岗位编码不能为空")
    private String postCode;

    @Schema(description = "岗位名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "postName岗位名称不能为空")
    private String postName;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "sort显示顺序不能为空")
    private Integer sort;

    @Schema(description = "岗位状态（0：停用，1:正常）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status岗位状态（0：停用，1:正常）不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}

