package com.example.springboottpl.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("查询岗位信息列表响应vo")
public class QueryPostListRespVo implements Serializable {


    @ApiModelProperty("岗位ID")
    private Integer postId;

    @ApiModelProperty("租户编号")
    private String tenantId;

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("岗位编码")
    private String postCode;

    @ApiModelProperty("岗位类别编码")
    private String postCategory;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("显示顺序")
    private Integer postSort;

    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建部门")
    private Integer createDept;

    @ApiModelProperty("创建者")
    private Integer createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新者")
    private Integer updateBy;

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
