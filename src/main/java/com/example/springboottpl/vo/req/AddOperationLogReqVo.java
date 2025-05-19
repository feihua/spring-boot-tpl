package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025-01-16 16:34:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "操作日志请求addVo")
public class AddOperationLogReqVo implements Serializable {

    @Schema(description = "系统模块")
    private String title;
    @Schema(description = "操作人员")
    private Long userId;
    @Schema(description = "操作人员")
    private String userName;
    @Schema(description = "部门id")
    private Long deptId;
    @Schema(description = "部门名称")
    private String deptName;
    @Schema(description = "IP地址")
    private String operateIp;
    @Schema(description = "请求URL")
    private String operationUrl;
    @Schema(description = "请求方式")
    private String requestMethod;
    @Schema(description = "操作描述")
    private String operationDesc;
    @Schema(description = "操作状态(0:异常,正常)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status操作状态(0:异常,正常)不能为空")
    private Integer status;
    @Schema(description = "平台信息")
    private String platform;
    @Schema(description = "操作系统")
    private String os;
    @Schema(description = "浏览器类型")
    private String browser;
    @Schema(description = "浏览器版本")
    private String version;
    @Schema(description = "渲染引擎信息")
    private String engine;
    @Schema(description = "请求参数")
    private String operateParam;
    @Schema(description = "操作结果")
    private String jsonResult;
    @Schema(description = "异常消息")
    private String errorMsg;
    @Schema(description = "详细的异常信息")
    private String errMsgDetail;
    @Schema(description = "耗时")
    private Long costTime;
    @Schema(description = "操作时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "operateTime操作时间不能为空")
    private Date operateTime;


}
