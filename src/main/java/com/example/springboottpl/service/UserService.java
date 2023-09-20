package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserReqVo;
import com.example.springboottpl.vo.req.UserListReqVo;
import com.example.springboottpl.vo.req.UserAddReqVo;
import com.example.springboottpl.vo.req.UserDeleteReqVo;
import com.example.springboottpl.vo.req.UserUpdateReqVo;
import com.example.springboottpl.vo.resp.UserRespVo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
public interface UserService {

   /**
    * 添加用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int saveUser(UserAddReqVo user);

   /**
    * 删除用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int deleteUser(UserDeleteReqVo user);

   /**
    * 更新用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int updateUser(UserUpdateReqVo user);

   /**
    * 查询用户信息
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   UserRespVo queryUser(UserReqVo user);

   /**
    * 查询用户信息列表
    *
    * @param user 请求参数
    * @return ResultPage<UserResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   ResultPage<UserRespVo> queryUserList(UserListReqVo user);

}