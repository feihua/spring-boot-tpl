package com.example.tpl.system.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户信息响应vo")
public class QueryUserListRespVo implements Serializable {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "手机号码")
    private String mobile;

    @Schema(description = "用户账号")
    private String userName;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "用户类型（00系统用户）")
    private String userType;

    @Schema(description = "头像路径")
    private String avatar;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "状态(1:正常，0:禁用)")
    private int status;

    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "最后登录IP")
    private String loginIp;

    @Schema(description = "最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginDate;

    @Schema(description = "浏览器类型")
    private String loginBrowser;

    @Schema(description = "操作系统")
    private String loginOs;

    @Schema(description = "密码最后更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pwdUpdateDate;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "删除标志（0代表删除 1代表存在）")
    private Integer delFlag;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
