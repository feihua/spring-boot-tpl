package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

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
@Schema(description = "角色和部门关联请求updateVo")
public class UpdateRoleDeptStatusReqVo implements Serializable {

    @Schema(description = "主键数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ids不能为空")
    private List<Integer> ids;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status状态不能为空")
    private Integer status;


}

