package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述：用户登录信息
 * 作者：刘飞华
 * 日期：2025/01/10 16:00:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户登录请求参数Vo")
public class UserLoginReqVo implements Serializable {

    @Schema(description = "手机", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "mobile手机不能为空")
    private String mobile;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "password密码不能为空")
    private String password;

}