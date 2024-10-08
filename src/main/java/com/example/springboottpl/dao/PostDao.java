package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.PostBean;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Mapper
public interface PostDao {

   /**
    * 添加岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int addPost(PostBean post);

   /**
    * 删除岗位信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deletePost(List<Integer> ids);

   /**
    * 更新岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updatePost(PostBean post);

      /**
       * 更新岗位信息状态
       *
       * @param post 请求参数
       * @return int
       * @author 刘飞华
       * @date: 2024-10-08 14:26:30
       */
      int updatePostStatus(PostBean post);

   /**
    * 查询岗位信息详情
    *
    * @param post 请求参数
    * @return Post
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   PostBean queryPostDetail(PostBean post);

   /**
    * 查询岗位信息列表
    *
    * @param post 请求参数
    * @return List<Post>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   List<PostBean> queryPostList(PostBean post);

}
