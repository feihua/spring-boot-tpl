package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：菜单角色关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuBean implements Serializable {
    //主键
    private Long id;
    //角色ID
    private Long roleId;
    //菜单ID
    private Long menuId;
    //创建时间
    private Date createTime;

    public RoleMenuBean(Long roleId, Long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
