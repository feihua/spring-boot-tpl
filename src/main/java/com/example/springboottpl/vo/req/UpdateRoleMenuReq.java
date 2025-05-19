package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "更新用户角色信息参数")
public class UpdateRoleMenuReq implements Serializable {

    @Schema(description = "用户ID")
    @NotNull(message = "userId用户ID不能为空")
    private List<Long> menuIds;
    @Schema(description = "角色ID")
    @NotNull(message = "roleId角色ID不能为空")
    private Long roleId;
}
