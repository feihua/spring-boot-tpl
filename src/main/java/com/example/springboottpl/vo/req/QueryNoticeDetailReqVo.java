package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025/01/10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "通知公告请求参数vo")
public class QueryNoticeDetailReqVo implements Serializable {


    @Schema(description = "公告Id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id公告Id不能为空")
    private Long id;


}
