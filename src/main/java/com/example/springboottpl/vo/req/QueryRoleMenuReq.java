package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "查询角色菜单信息请求参数")
public class QueryRoleMenuReq implements Serializable {

    @Schema(description = "角色ID")
    @NotNull(message = "roleId角色ID不能为空")
    private Long roleId;
}
