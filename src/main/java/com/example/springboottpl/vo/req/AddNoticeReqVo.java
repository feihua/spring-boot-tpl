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
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "通知公告请求addVo")
public class AddNoticeReqVo implements Serializable {

    @Schema(description = "公告标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "noticeTitle公告标题不能为空")
    private String noticeTitle;

    @Schema(description = "公告类型（1:通知,2:公告）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "noticeType公告类型（1:通知,2:公告）不能为空")
    private Integer noticeType;

    @Schema(description = "公告内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "noticeContent公告内容不能为空")
    private String noticeContent;

    @Schema(description = "公告状态（0:关闭,1:正常 ）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status公告状态（0:关闭,1:正常 ）不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
