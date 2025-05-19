package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "批量取消授权用户请求参数")
public class CancelAuthUserAllReq implements Serializable {

    @Schema(description = "用户ID")
    @NotNull(message = "userIds用户ID不能为空")
    private List<Long> userIds;
    @Schema(description = "角色ID")
    @NotNull(message = "roleId角色ID不能为空")
    private Long roleId;
}
