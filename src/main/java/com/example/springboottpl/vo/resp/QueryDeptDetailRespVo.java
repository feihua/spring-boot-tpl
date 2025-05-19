package com.example.tpl.system.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "部门响应vo")
public class QueryDeptDetailRespVo implements Serializable {

    @Schema(description = "部门id")
    private Long id;

    @Schema(description = "父部门id")
    private Long parentId;

    @Schema(description = "祖级列表")
    private String ancestors;

    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "负责人")
    private String leader;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "部门状态（0：停用，1:正常）")
    private int status;

    @Schema(description = "删除标志（0代表删除 1代表存在）")
    private Integer delFlag;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
