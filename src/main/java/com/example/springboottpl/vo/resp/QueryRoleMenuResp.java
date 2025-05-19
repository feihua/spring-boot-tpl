package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "查询角色关联的菜单响应")
public class QueryRoleMenuResp implements Serializable {

    @Schema(description = "菜单Ids")
    private List<Long> menuIds;
    @Schema(description = "菜单列表")
    private List<QueryRoleMenuData> menuList;
}
