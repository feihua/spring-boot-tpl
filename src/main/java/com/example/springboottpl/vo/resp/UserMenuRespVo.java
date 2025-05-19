package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户菜单
 * 作者：刘飞华
 * 日期：2025/1/11 11:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户菜单响应vo")
public class UserMenuRespVo implements Serializable {

    @Schema(description = "按钮权限")
    private List<String> btnMenu;

    @Schema(description = "左侧菜单数据")
    private List<QueryUserMenuListData> sysMenu;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "图像地址")
    private String avatar;

}