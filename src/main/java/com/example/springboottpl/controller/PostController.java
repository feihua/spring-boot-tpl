package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.service.PostService;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Api(tags = "岗位信息")
@RestController
@RequestMapping("/post")
public class PostController {

   @Autowired
   private PostService postService;

   /**
    * 添加岗位信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("添加岗位信息")
   @PostMapping("/addPost")
   @OperateLog(description = "【岗位信息】添加岗位信息")
   public Integer addPost(@RequestBody @Valid AddPostReqVo record){
        return postService.addPost(record);
   }

   /**
    * 删除岗位信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("删除岗位信息")
   @PostMapping("/deletePost")
   @OperateLog(description = "【岗位信息】删除岗位信息")
   public Integer deletePost(@RequestBody @Valid DeletePostReqVo record){
        return postService.deletePost(record);
   }

   /**
    * 更新岗位信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("更新岗位信息")
   @PostMapping("/updatePost")
   @OperateLog(description = "【岗位信息】更新岗位信息")
   public Integer updatePost(@RequestBody @Valid UpdatePostReqVo record){
        return postService.updatePost(record);
   }

   /**
   * 更新岗位信息状态
   *
   * @param record 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2024-10-08 14:26:31
   */
  @ApiOperation("更新岗位信息状态")
  @PostMapping("/updatePostStatus")
  @OperateLog(description = "【岗位信息】更新岗位信息状态")
  public Integer updatePostStatus(@RequestBody @Valid UpdatePostStatusReqVo record){
       return postService.updatePostStatus(record);
  }

   /**
    * 查询岗位信息详情
    *
    * @param record 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("查询岗位信息详情")
   @PostMapping("/queryPostDetail")
   @OperateLog(description = "【岗位信息】查询岗位信息详情")
   public QueryPostDetailRespVo queryPostDetail(@RequestBody @Valid QueryPostDetailReqVo record){
       return postService.queryPostDetail(record);
   }

   /**
    * 查询岗位信息列表
    *
    * @param record 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("查询岗位信息列表")
   @PostMapping("/queryPostList")
   @OperateLog(description = "【岗位信息】查询岗位信息列表")
   public QueryPostListRespVo queryPostList(@RequestBody @Valid QueryPostListReqVo record){
        return postService.queryPostList(record);
   }

}
