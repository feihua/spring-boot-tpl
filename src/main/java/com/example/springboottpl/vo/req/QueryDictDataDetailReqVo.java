package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "字典数据请求vo")
public class QueryDictDataDetailReqVo implements Serializable {


    @Schema(description = "字典编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "dictCode字典编码不能为空")
    private Long dictCode;


}
