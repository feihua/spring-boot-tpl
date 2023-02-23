package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色信息响应vo")
public class RoleResp implements Serializable {

    @ApiModelProperty("主键")
    private long id;

    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    @ApiModelProperty("修改时间")
    private Date gmtModified;

    @ApiModelProperty("状态(1:正常，0:禁用)")
    private short statusId;

    @ApiModelProperty("排序")
    private int sort;

    @ApiModelProperty("名称")
    private String roleName;

    @ApiModelProperty("备注")
    private String remark;

}