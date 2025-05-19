package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "查询已分配用户角色请求参数")
public class AllocatedListReq implements Serializable {

    @Schema(description = "当前页", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "pageNo当前页不能为空")
    @Min(value = 1, message = "pageNo当前页不能小于1")
    private Integer pageNo;

    @Schema(description = "每页的数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "pageSize每页的数量不能为空")
    private Integer pageSize;

    @Schema(description = "角色ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "roleId角色ID不能为空")
    private Long roleId;

    @Schema(description = "手机号码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String mobile;

    @Schema(description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
}
