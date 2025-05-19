package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
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
@Schema(description = "字典数据请求listVo")
public class QueryDictDataListReqVo implements Serializable {

    @Schema(description = "当前页", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "pageNo当前页不能为空")
    @Min(value = 1, message = "pageNo当前页不能小于1")
    private Integer pageNo;

    @Schema(description = "每页的数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @Schema(description = "字典标签")
    private String dictLabel;
    @Schema(description = "字典类型")
    private String dictType;
    @Schema(description = "状态（0：停用，1:正常）")
    private Integer status;

}

