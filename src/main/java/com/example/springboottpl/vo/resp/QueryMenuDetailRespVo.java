package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "菜单信息响应vo")
public class QueryMenuDetailRespVo implements Serializable {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单类型(1：目录   2：菜单   3：按钮)")
    private Integer menuType;

    @Schema(description = "显示状态（0:隐藏, 显示:1）")
    private Integer visible;

    @Schema(description = "菜单状态(1:正常，0:禁用)")
    private int status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "父ID")
    private Long parentId;

    @Schema(description = "路由路径")
    private String menuUrl;

    @Schema(description = "接口URL")
    private String apiUrl;

    @Schema(description = "菜单图标")
    private String menuIcon;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
