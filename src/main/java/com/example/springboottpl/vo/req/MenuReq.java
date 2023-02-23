package com.example.springboottpl.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("菜单信息请求vo")
public class MenuReq implements Serializable {

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

    @ApiModelProperty("父ID")
    //@NotNull(message = "parentId父ID不能为空")
    private long parentId;

    @ApiModelProperty("菜单名称")
    //@NotNull(message = "menuName菜单名称不能为空")
    private String menuName;

    @ApiModelProperty("路由路径")
    //@NotNull(message = "menuUrl路由路径不能为空")
    private String menuUrl;

    @ApiModelProperty("接口URL")
    //@NotNull(message = "apiUrl接口URL不能为空")
    private String apiUrl;

    @ApiModelProperty("菜单图标")
    //@NotNull(message = "menuIcon菜单图标不能为空")
    private String menuIcon;

    @ApiModelProperty("备注")
    //@NotNull(message = "remark备注不能为空")
    private String remark;

    @ApiModelProperty("菜单类型(1：目录   2：菜单   3：按钮)")
    //@NotNull(message = "menuType菜单类型(1：目录   2：菜单   3：按钮)不能为空")
    private short menuType;

}