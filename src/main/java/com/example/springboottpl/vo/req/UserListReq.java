package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：后台用户信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("后台用户信息请求listVVo")
public class UserListReq implements Serializable {

    @ApiModelProperty("当前页")
    @NotNull(message = "current当前页不能为空")
    @Min(value=1,message = "current当前页不能小于1")
    private int current;

    @ApiModelProperty("每页的数量")
    @NotNull(message = "pageSize每页的数量不能为空")
    private int pageSize;

    @ApiModelProperty("主键")
    //@NotNull(message = "id主键不能为空")
    private long id;

    @ApiModelProperty("创建时间")
    //@NotNull(message = "gmtCreate创建时间不能为空")
    private Date gmtCreate;

    @ApiModelProperty("修改时间")
    //@NotNull(message = "gmtModified修改时间不能为空")
    private Date gmtModified;

    @ApiModelProperty("状态(1:正常，0:禁用)")
    //@NotNull(message = "statusId状态(1:正常，0:禁用)不能为空")
    private short statusId;

    @ApiModelProperty("排序")
    //@NotNull(message = "sort排序不能为空")
    private int sort;

    @ApiModelProperty("用户编号")
    //@NotNull(message = "userNo用户编号不能为空")
    private long userNo;

    @ApiModelProperty("手机")
    //@NotNull(message = "mobile手机不能为空")
    private String mobile;

    @ApiModelProperty("真实姓名")
    //@NotNull(message = "realName真实姓名不能为空")
    private String realName;

    @ApiModelProperty("备注")
    //@NotNull(message = "remark备注不能为空")
    private String remark;

    @ApiModelProperty("密码")
    //@NotNull(message = "password密码不能为空")
    private String password;

}