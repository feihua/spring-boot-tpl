package com.example.springboottpl.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "菜单信息请求addVo")
public class AddMenuReqVo implements Serializable {

    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "menuName菜单名称不能为空")
    private String menuName;

    @Schema(description = "菜单类型(1：目录   2：菜单   3：按钮)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "menuType菜单类型(1：目录   2：菜单   3：按钮)不能为空")
    private Integer menuType;

    @Schema(description = "显示状态（0:隐藏, 显示:1）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "visible显示状态（0:隐藏, 显示:1）不能为空")
    private Integer visible;

    @Schema(description = "菜单状态(1:正常，0:禁用)", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "status菜单状态(1:正常，0:禁用)不能为空")
    private Integer status;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "sort排序不能为空")
    private Integer sort;

    @Schema(description = "父ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long parentId;

    @Schema(description = "路由路径", requiredMode = Schema.RequiredMode.REQUIRED)
    private String menuUrl;

    @Schema(description = "接口URL", requiredMode = Schema.RequiredMode.REQUIRED)
    private String apiUrl;

    @Schema(description = "菜单图标", requiredMode = Schema.RequiredMode.REQUIRED)
    private String menuIcon;

    @Schema(description = "备注")
    private String remark;

}
