package com.example.springboottpl.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：用户与岗位关联
 * 作者：刘飞华
 * 日期：2025-01-10 15:23:47
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户与岗位关联响应vo")
public class QueryUserPostDetailRespVo implements Serializable {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "岗位id")
    private Long postId;

}
