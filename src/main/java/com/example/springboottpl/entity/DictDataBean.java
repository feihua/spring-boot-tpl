package com.example.tpl.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictDataBean implements Serializable {
    //字典编码
    private Long dictCode;
    //字典排序
    private Integer dictSort;
    //字典标签
    private String dictLabel;
    //字典键值
    private String dictValue;
    //字典类型
    private String dictType;
    //样式属性（其他样式扩展）
    private String cssClass;
    //表格回显样式
    private String listClass;
    //是否默认（Y是 N否）
    private String isDefault;
    //状态（0：停用，1:正常）
    private Integer status;
    //备注
    private String remark;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
