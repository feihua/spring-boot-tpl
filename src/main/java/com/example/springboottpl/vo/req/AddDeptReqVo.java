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
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "部门请求addVo")
public class AddDeptReqVo implements Serializable {

    @Schema(description = "父部门id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "parentId父部门id不能为空")
    private Long parentId;

    @Schema(description = "部门名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "deptName部门名称不能为空")
    private String deptName;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "sort显示顺序不能为空")
    private Integer sort;

    @Schema(description = "负责人", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "leader负责人不能为空")
    private String leader;

    @Schema(description = "联系电话", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "phone联系电话不能为空")
    private String phone;

    @Schema(description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "email邮箱不能为空")
    private String email;

    @Schema(description = "部门状态（0：停用，1:正常）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status部门状态（0：停用，1:正常）不能为空")
    private Integer status;


}
