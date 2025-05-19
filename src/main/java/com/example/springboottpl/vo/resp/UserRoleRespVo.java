package com.example.tpl.system.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户的角色
 * 作者：刘飞华
 * 日期：2025/1/11 11:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户的角色响应vo")
public class UserRoleRespVo implements Serializable {

    @Schema(description = "角色拥有的角色ids")
    private List<Long> userRoleIds;

    @Schema(description = "所有的角色")
    private List<QueryRoleDetailRespVo> sysRoleList;
}
