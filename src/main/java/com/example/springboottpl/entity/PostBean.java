package com.example.springboottpl.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostBean implements Serializable {
    //岗位id
    private Long id;
    //岗位编码
    private String postCode;
    //岗位名称
    private String postName;
    //显示顺序
    private Integer sort;
    //岗位状态（0：停用，1:正常）
    private Integer status;
    //备注
    private String remark;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
