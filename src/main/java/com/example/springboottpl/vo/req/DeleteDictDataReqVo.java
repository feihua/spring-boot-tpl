package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

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
public class DeleteDictDataReqVo implements Serializable {

    @Schema(description = "主键数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ids不能为空")
    private List<Integer> ids;
}

