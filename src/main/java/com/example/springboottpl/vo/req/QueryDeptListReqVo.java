package com.example.tpl.system.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "部门请求listVo")
public class QueryDeptListReqVo implements Serializable {

    @Schema(description = "部门名称")
    private String deptName;
    @Schema(description = "部门状态（0：停用，1:正常）")
    private Integer status;

}

