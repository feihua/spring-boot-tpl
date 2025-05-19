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
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "操作日志请求updateVo")
public class UpdateOperationLogReqVo implements Serializable {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id主键不能为空")
    private Long id;

    @Schema(description = "操作者ID")
    private Long userId;
    @Schema(description = "操作者姓名")
    private String userName;
    @Schema(description = "IP地址")
    private String ipAddress;
    @Schema(description = "操作url")
    private String operationUrl;
    @Schema(description = "操作方法")
    private String operationMethod;
    @Schema(description = "操作描述", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "operationDesc操作描述不能为空")
    private String operationDesc;

    @Schema(description = "操作状态[0:失败,1:成功]")
    private Integer operationStatus;
    @Schema(description = "请求参数")
    private String requestParams;
    @Schema(description = "操作结果")
    private String responseParams;
    @Schema(description = "异常消息")
    private String errMessage;
    @Schema(description = "详细的异常信息")
    private String errMessageDetail;
    @Schema(description = "耗时")
    private Long useTime;

}

