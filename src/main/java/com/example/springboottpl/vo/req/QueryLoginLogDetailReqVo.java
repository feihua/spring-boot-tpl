package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "系统访问记录请求vo")
public class QueryLoginLogDetailReqVo implements Serializable {


    @Schema(description = "访问ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id访问ID不能为空")
    private Long id;


}
