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
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "系统访问记录请求updateVo")
public class UpdateLoginLogReqVo implements Serializable {

    @Schema(description = "访问ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id访问ID不能为空")
    private Long id;

    @Schema(description = "登录账号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "loginName登录账号不能为空")
    private String loginName;

    @Schema(description = "登录IP地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "ipaddr登录IP地址不能为空")
    private String ipaddr;

    @Schema(description = "登录地点", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "loginLocation登录地点不能为空")
    private String loginLocation;

    @Schema(description = "平台信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "platform平台信息不能为空")
    private String platform;

    @Schema(description = "浏览器类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "browser浏览器类型不能为空")
    private String browser;

    @Schema(description = "浏览器版本", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "version浏览器版本不能为空")
    private String version;

    @Schema(description = "操作系统", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "os操作系统不能为空")
    private String os;

    @Schema(description = "体系结构信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "arch体系结构信息不能为空")
    private String arch;

    @Schema(description = "渲染引擎信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "engine渲染引擎信息不能为空")
    private String engine;

    @Schema(description = "渲染引擎详细信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "engineDetails渲染引擎详细信息不能为空")
    private String engineDetails;

    @Schema(description = "其他信息（可选）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "extra其他信息（可选）不能为空")
    private String extra;

    @Schema(description = "登录状态(0:失败,1:成功)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status登录状态(0:失败,1:成功)不能为空")
    private Integer status;

    @Schema(description = "提示消息", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "msg提示消息不能为空")
    private String msg;

    @Schema(description = "访问时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "loginTime访问时间不能为空")
    private Date loginTime;


}

