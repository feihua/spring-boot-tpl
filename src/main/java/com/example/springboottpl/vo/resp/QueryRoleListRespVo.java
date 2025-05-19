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
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色信息响应vo")
public class QueryRoleListRespVo implements Serializable {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "名称")
    private String roleName;

    @Schema(description = "角色权限字符串")
    private String roleKey;

    @Schema(description = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private Integer dataScope;

    @Schema(description = "状态(1:正常，0:禁用)")
    private int status;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "删除标志（0代表删除 1代表存在）")
    private Integer delFlag;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
