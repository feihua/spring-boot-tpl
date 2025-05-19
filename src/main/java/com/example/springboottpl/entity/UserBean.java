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
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {
    //主键
    private Long id;
    //手机号码
    private String mobile;
    //用户账号
    private String userName;
    //用户昵称
    private String nickName;
    //用户类型（00系统用户）
    private String userType;
    //头像路径
    private String avatar;
    //用户邮箱
    private String email;
    //密码
    private String password;
    //状态(1:正常，0:禁用)
    private Integer status;
    //部门ID
    private Long deptId;
    //最后登录IP
    private String loginIp;
    //最后登录时间
    private Date loginDate;
    //浏览器类型
    private String loginBrowser;
    //操作系统
    private String loginOs;
    //密码最后更新时间
    private Date pwdUpdateDate;
    //备注
    private String remark;
    //删除标志（0代表删除 1代表存在）
    private Integer delFlag;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
