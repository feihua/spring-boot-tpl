package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

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
@Schema(description = "菜单信息请求listVo")
public class QueryMenuListReqVo implements Serializable {

    @Schema(description = "菜单名称")
    private String menuName;
    @Schema(description = "菜单类型(1：目录   2：菜单   3：按钮)")
    private Integer menuType;
    @Schema(description = "显示状态（0:隐藏, 显示:1）")
    private Integer visible;
    @Schema(description = "菜单状态(1:正常，0:禁用)")
    private Integer status;

}

