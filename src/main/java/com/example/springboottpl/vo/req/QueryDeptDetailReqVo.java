package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "部门请求vo")
public class QueryDeptDetailReqVo implements Serializable {


    @Schema(description = "部门id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id部门id不能为空")
    private Long id;


}
