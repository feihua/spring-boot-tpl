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
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色信息请求addVo")
public class AddRoleReqVo implements Serializable {

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "roleName名称不能为空")
    private String roleName;

    @Schema(description = "角色权限字符串", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "roleKey角色权限字符串不能为空")
    private String roleKey;

    @Schema(description = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "dataScope数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）不能为空")
    private Integer dataScope;

    @Schema(description = "状态(1:正常，0:禁用)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status状态(1:正常，0:禁用)不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;


}
