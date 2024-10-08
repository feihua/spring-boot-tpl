package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2024-10-08 17:42:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {
    //用户ID
    private Long userId;
    //租户编号
    private String tenantId;
    //部门ID
    private Long deptId;
    //用户账号
    private String userName;
    //用户昵称
    private String nickName;
    //用户类型（sys_user系统用户）
    private String userType;
    //用户邮箱
    private String email;
    //手机号码
    private String phone;
    //用户性别（0男 1女 2未知）
    private String sex;
    //头像地址
    private String avatar;
    //密码
    private String password;
    //部门状态(1:正常，0:禁用)
    private Integer status;
    //删除标志（0代表存在 1代表删除）
    private Integer delFlag;
    //最后登录操作系统
    private String loginOs;
    //最后登录浏览器
    private String loginBrowser;
    //最后登录IP
    private String loginIp;
    //最后登录时间
    private Date loginTime;
    //备注
    private String remark;
    //创建部门
    private Long createDept;
    //创建者
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新者
    private Long updateBy;
    //更新时间
    private Date updateTime;
}
