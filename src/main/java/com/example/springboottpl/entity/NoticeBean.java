package com.example.tpl.system.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBean implements Serializable {
    //公告ID
    private Long id;
    //公告标题
    private String noticeTitle;
    //公告类型（1:通知,2:公告）
    private Integer noticeType;
    //公告内容
    private String noticeContent;
    //公告状态（0:关闭,1:正常 ）
    private Integer status;
    //备注
    private String remark;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
}
