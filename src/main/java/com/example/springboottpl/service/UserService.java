package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserReq;
import com.example.springboottpl.vo.req.UserListReq;
import com.example.springboottpl.vo.req.UserAddReq;
import com.example.springboottpl.vo.req.UserUpdateReq;
import com.example.springboottpl.vo.resp.UserResp;

/**
 * 描述：后台用户信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:26
 */
public interface UserService {

   /**
    * 查询后台用户信息
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   UserResp query(UserReq user);

   /**
    * 查询后台用户信息列表
    *
    * @param user 请求参数
    * @return ResultPage<UserResp>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   ResultPage<UserResp> queryUserList(UserListReq user);

   /**
    * 添加后台用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   int insert(UserAddReq user);

   /**
    * 删除后台用户信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   int delete(String ids);

   /**
    * 更新后台用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   int update(UserUpdateReq user);

}