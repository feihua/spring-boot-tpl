package com.example.springboottpl.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色和菜单关联
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuBean implements Serializable {
    //角色ID
    private Long roleId;
    //菜单ID
    private Long menuId;
}
