package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

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
@Schema(description = "角色和部门关联响应vo")
public class QueryRoleDeptListRespVo implements Serializable {

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "部门id")
    private Long deptId;

}
