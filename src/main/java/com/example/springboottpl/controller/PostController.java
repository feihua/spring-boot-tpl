package com.example.tpl.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.tpl.system.annotation.OperateLog;
import com.example.tpl.system.service.PostService;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddPostReqVo;
import com.example.tpl.system.vo.req.DeletePostReqVo;
import com.example.tpl.system.vo.req.QueryPostDetailReqVo;
import com.example.tpl.system.vo.req.QueryPostListReqVo;
import com.example.tpl.system.vo.req.UpdatePostReqVo;
import com.example.tpl.system.vo.req.UpdatePostStatusReqVo;
import com.example.tpl.system.vo.resp.QueryPostDetailRespVo;
import com.example.tpl.system.vo.resp.QueryPostListRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "7.岗位管理")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 添加岗位信息
     *
     * @param post 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "1.1 添加岗位信息")
    @PostMapping("/addPost")
    @OperateLog(description = "【岗位信息】添加岗位信息")
    public Result<Integer> addPost(@RequestBody @Valid AddPostReqVo post) {
        return postService.addPost(post);
    }

    /**
     * 删除岗位信息
     *
     * @param post 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "1.2 删除岗位信息")
    @PostMapping("/deletePost")
    @OperateLog(description = "【岗位信息】删除岗位信息")
    public Result<Integer> deletePost(@RequestBody @Valid DeletePostReqVo post) {
        return postService.deletePost(post);
    }

    /**
     * 更新岗位信息
     *
     * @param post 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "1.3 更新岗位信息")
    @PostMapping("/updatePost")
    @OperateLog(description = "【岗位信息】更新岗位信息")
    public Result<Integer> updatePost(@RequestBody @Valid UpdatePostReqVo post) {
        return postService.updatePost(post);
    }

    /**
     * 更新岗位信息状态
     *
     * @param post 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "1.4 更新岗位信息状态")
    @PostMapping("/updatePostStatus")
    @OperateLog(description = "【岗位信息】更新岗位信息状态")
    public Result<Integer> updatePostStatus(@RequestBody @Valid UpdatePostStatusReqVo post) {
        return postService.updatePostStatus(post);
    }

    /**
     * 查询岗位信息详情
     *
     * @param post 请求参数
     * @return PostResp
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "1.5 查询岗位信息详情")
    @PostMapping("/queryPostDetail")
    @OperateLog(description = "【岗位信息】查询岗位信息详情")
    public Result<QueryPostDetailRespVo> queryPostDetail(@RequestBody @Valid QueryPostDetailReqVo post) {
        return postService.queryPostDetail(post);
    }

    /**
     * 查询岗位信息列表
     *
     * @param post 请求参数
     * @return PostResp
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "1.6 查询岗位信息列表")
    @PostMapping("/queryPostList")
    @OperateLog(description = "【岗位信息】查询岗位信息列表")
    public Result<ResultPage<QueryPostListRespVo>> queryPostList(@RequestBody @Valid QueryPostListReqVo post) {
        return postService.queryPostList(post);
    }

}
