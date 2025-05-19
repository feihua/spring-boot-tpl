package com.example.springboottpl.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户与岗位关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPostBean implements Serializable {
    //用户id
    private Long userId;
    //岗位id
    private Long postId;
}
