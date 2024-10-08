package com.example.springboottpl.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户和角色关联
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleBean implements Serializable {
    //用户ID
    private Long userId;
    //角色ID
    private Long roleId;
}
