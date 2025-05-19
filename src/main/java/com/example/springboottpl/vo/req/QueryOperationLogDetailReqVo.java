package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "操作日志请求vo")
public class QueryOperationLogDetailReqVo implements Serializable {


    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id主键不能为空")
    private Long id;


}
