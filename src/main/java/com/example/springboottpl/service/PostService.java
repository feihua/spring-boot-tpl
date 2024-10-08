package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
public interface PostService {

   /**
    * 添加岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int addPost(AddPostReqVo post);

   /**
    * 删除岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int deletePost(DeletePostReqVo post);

   /**
    * 更新岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updatePost(UpdatePostReqVo post);

   /**
    * 更新岗位信息状态
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updatePostStatus(UpdatePostStatusReqVo post);


   /**
    * 查询岗位信息详情
    *
    * @param post 请求参数
    * @return QueryPostDetailResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   QueryPostDetailRespVo queryPostDetail(QueryPostDetailReqVo post);

   /**
    * 查询岗位信息列表
    *
    * @param post 请求参数
    * @return QueryPostListResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   QueryPostListRespVo queryPostList(QueryPostListReqVo post);

}