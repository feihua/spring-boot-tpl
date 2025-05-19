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
 * 描述：用户与岗位关联
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户与岗位关联请求updateVo")
public class UpdateUserPostReqVo implements Serializable {

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "userId用户id不能为空")
    private Long userId;

    @Schema(description = "岗位id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "postId岗位id不能为空")
    private Long postId;


}

