package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.PostBiz;
import com.example.springboottpl.service.PostService;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Service
public class PostServiceImpl implements PostService {

   @Autowired
   private PostBiz postBiz;

   /**
    * 添加岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int addPost(AddPostReqVo post){

        return postBiz.addPost(post);
   }

   /**
    * 删除岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int deletePost(DeletePostReqVo post){
		return postBiz.deletePost(post);
   }

   /**
    * 更新岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int updatePost(UpdatePostReqVo post){

        return postBiz.updatePost(post);
   }

   /**
   * 更新岗位信息状态
   *
   * @param post 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2024-10-08 14:26:31
   */
  @Override
  public int updatePostStatus(UpdatePostStatusReqVo post){

       return postBiz.updatePostStatus(post);
  }

   /**
    * 查询岗位信息详情
    *
    * @param post 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryPostDetailRespVo queryPostDetail(QueryPostDetailReqVo post){

       return postBiz.queryPostDetail(post);
   }

   /**
    * 查询岗位信息列表
    *
    * @param post 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryPostListRespVo queryPostList(QueryPostListReqVo post){

        return postBiz.queryPostList(post);
   }

}