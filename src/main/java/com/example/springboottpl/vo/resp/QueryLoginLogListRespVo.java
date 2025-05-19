package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "系统访问记录响应vo")
public class QueryLoginLogListRespVo implements Serializable {

    @Schema(description = "访问ID")
    private Long id;

    @Schema(description = "登录账号")
    private String loginName;

    @Schema(description = "登录IP地址")
    private String ipaddr;

    @Schema(description = "登录地点")
    private String loginLocation;

    @Schema(description = "平台信息")
    private String platform;

    @Schema(description = "浏览器类型")
    private String browser;

    @Schema(description = "浏览器版本")
    private String version;

    @Schema(description = "操作系统")
    private String os;

    @Schema(description = "体系结构信息")
    private String arch;

    @Schema(description = "渲染引擎信息")
    private String engine;

    @Schema(description = "渲染引擎详细信息")
    private String engineDetails;

    @Schema(description = "其他信息（可选）")
    private String extra;

    @Schema(description = "登录状态(0:失败,1:成功)")
    private int status;

    @Schema(description = "提示消息")
    private String msg;

    @Schema(description = "访问时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;

}
