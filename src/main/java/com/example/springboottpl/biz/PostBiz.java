package com.example.tpl.system.biz;

import java.util.Map;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.*;
import com.example.tpl.system.vo.resp.*;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface PostBiz {

   /**
    * 添加岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addPost(AddPostReqVo post);

   /**
    * 删除岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deletePost(DeletePostReqVo post);

   /**
    * 更新岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updatePost(UpdatePostReqVo post);

   /**
    * 更新岗位信息状态
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updatePostStatus(UpdatePostStatusReqVo post);

   /**
    * 查询岗位信息详情
    *
    * @param post 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryPostDetailRespVo> queryPostDetail(QueryPostDetailReqVo post);

   /**
    * 查询岗位信息列表
    *
    * @param post 请求参数
    * @return ResultPage<PostResp>
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<ResultPage<QueryPostListRespVo>> queryPostList(QueryPostListReqVo post);

}