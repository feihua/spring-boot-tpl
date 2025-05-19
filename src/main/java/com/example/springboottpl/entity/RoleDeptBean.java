package com.example.tpl.system.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色和部门关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDeptBean implements Serializable {
    //角色id
    private Long roleId;
    //部门id
    private Long deptId;
}
