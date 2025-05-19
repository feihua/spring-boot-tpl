package com.example.tpl.system.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "查询角色关联的菜单响应")
public class QueryRoleMenuData implements Serializable {

    @Schema(description = "菜单Ids")
    private Long id;
    @Schema(description = "主键")
    private String key;
    @Schema(description = "上级菜单id")
    private Long parentId;
    @Schema(description = "菜单名称")
    private String title;
    @Schema(description = "菜单名称")
    private String label;
    private boolean isPenultimate;
}
