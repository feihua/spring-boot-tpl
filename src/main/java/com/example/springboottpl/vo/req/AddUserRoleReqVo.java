package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色用户关联
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色用户关联请求addVo")
public class AddUserRoleReqVo implements Serializable {

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "userId用户ID不能为空")
    private Long userId;

    @Schema(description = "角色ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "roleId角色ID不能为空")
    private Long roleId;


}
