package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
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
@Schema(description = "菜单角色关联请求listVo")
public class QueryRoleMenuListReqVo implements Serializable {

    @Schema(description = "当前页", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "pageNo当前页不能为空")
    @Min(value = 1, message = "pageNo当前页不能小于1")
    private Integer pageNo;

    @Schema(description = "每页的数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @Schema(description = "角色ID")
    //@NotBlank(message = "roleId角色ID不能为空")
    private Long roleId;
    @Schema(description = "菜单ID")
    //@NotBlank(message = "menuId菜单ID不能为空")
    private Long menuId;

}

