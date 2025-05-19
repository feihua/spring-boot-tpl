package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：查询菜单信息(排除按钮)
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "查询菜单信息(排除按钮)响应vo")
public class QueryMenuSimpleListRespVo implements Serializable {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "父ID")
    private Long parentId;


}
