package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色和部门关联
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色和部门关联请求vo")
public class QueryRoleDeptDetailReqVo implements Serializable {


    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "roleId角色id不能为空")
    private Long roleId;
    @Schema(description = "部门id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "deptId部门id不能为空")
    private Long deptId;


}
