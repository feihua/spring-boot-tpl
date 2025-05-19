package com.example.springboottpl.vo.resp;

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
@Schema(description = "用户菜单信息响应data")
public class QueryUserMenuListData implements Serializable {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "菜单名称")
    private String name;

    @Schema(description = "菜单类型(1：目录   2：菜单   3：按钮)")
    private Integer menuType;

    @Schema(description = "父ID")
    private Long parentId;

    @Schema(description = "路由路径")
    private String path;

    @Schema(description = "接口URL")
    private String apiUrl;

    @Schema(description = "菜单图标")
    private String icon;


}
