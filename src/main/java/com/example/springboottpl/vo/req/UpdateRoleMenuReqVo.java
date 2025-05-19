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
 * 描述：菜单角色关联
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "菜单角色关联请求updateVo")
public class UpdateRoleMenuReqVo implements Serializable {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id主键不能为空")
    private Long id;

    @Schema(description = "角色ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "roleId角色ID不能为空")
    private Long roleId;

    @Schema(description = "菜单ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "menuId菜单ID不能为空")
    private Long menuId;


}

