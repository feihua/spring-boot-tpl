package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.UserPostBean;

/**
 * 描述：用户与岗位关联
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Mapper
public interface UserPostDao {

   /**
    * 添加用户与岗位关联
    *
    * @param userPost 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int addUserPost(UserPostBean userPost);

   /**
    * 删除用户与岗位关联
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int deleteUserPost(List<Integer> ids);

   /**
    * 更新用户与岗位关联
    *
    * @param userPost 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateUserPost(UserPostBean userPost);

      /**
       * 更新用户与岗位关联状态
       *
       * @param userPost 请求参数
       * @return int
       * @author 刘飞华
       * @date: 2024-10-08 14:26:31
       */
      int updateUserPostStatus(UserPostBean userPost);

   /**
    * 查询用户与岗位关联详情
    *
    * @param userPost 请求参数
    * @return UserPost
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   UserPostBean queryUserPostDetail(UserPostBean userPost);

   /**
    * 查询用户与岗位关联列表
    *
    * @param userPost 请求参数
    * @return List<UserPost>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   List<UserPostBean> queryUserPostList(UserPostBean userPost);

}
