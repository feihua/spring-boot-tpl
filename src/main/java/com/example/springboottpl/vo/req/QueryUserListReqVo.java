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
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户信息请求listVo")
public class QueryUserListReqVo implements Serializable {

    @Schema(description = "当前页", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "pageNo当前页不能为空")
    @Min(value = 1, message = "pageNo当前页不能小于1")
    private Integer pageNo;

    @Schema(description = "每页的数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @Schema(description = "手机号码")
    private String mobile;
    @Schema(description = "用户账号")
    private String userName;
    @Schema(description = "用户昵称")
    private String nickName;
    @Schema(description = "用户类型（00系统用户）")
    private String userType;
    @Schema(description = "用户邮箱")
    private String email;
    @Schema(description = "状态(1:正常，0:禁用)")
    private Integer status;
    @Schema(description = "部门ID")
    private Long deptId;

}

