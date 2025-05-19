package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户信息请求addVo")
public class AddUserReqVo implements Serializable {

    @Schema(description = "手机号码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "mobile手机号码不能为空")
    private String mobile;

    @Schema(description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "userName用户账号不能为空")
    private String userName;

    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "nickName用户昵称不能为空")
    private String nickName;

    @Schema(description = "头像路径", requiredMode = Schema.RequiredMode.REQUIRED)
    private String avatar;

    @Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "email用户邮箱不能为空")
    private String email;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "password密码不能为空")
    private String password;

    @Schema(description = "状态(1:正常，0:禁用)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status状态(1:正常，0:禁用)不能为空")
    private Integer status;

    @Schema(description = "部门ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "deptId部门ID不能为空")
    private Long deptId;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "岗位postIds", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "岗位postIds不能为空")
    private List<Long> postIds;


}
