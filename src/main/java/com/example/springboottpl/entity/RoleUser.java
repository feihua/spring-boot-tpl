package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleUser implements Serializable {

    //主键
    private long id;

    //创建时间
    private Date gmtCreate;

    //修改时间
    private Date gmtModified;

    //状态(1:正常，0:禁用)
    private short statusId;

    //排序
    private int sort;

    //角色ID
    private long roleId;

    //用户ID
    private long userId;

}
