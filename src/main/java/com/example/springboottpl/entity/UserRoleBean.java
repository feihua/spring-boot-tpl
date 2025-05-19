package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色用户关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleBean implements Serializable {

    //主键
    private Long id;
    //用户ID
    private Long userId;
    //角色ID
    private Long roleId;
    //创建时间
    private Date createTime;

    public UserRoleBean(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
