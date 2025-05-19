package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "岗位信息请求vo")
public class QueryPostDetailReqVo implements Serializable {


    @Schema(description = "岗位id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id岗位id不能为空")
    private Long id;


}
