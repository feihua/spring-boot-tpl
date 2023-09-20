package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserReqVo;
import com.example.springboottpl.vo.req.UserListReqVo;
import com.example.springboottpl.vo.req.UserAddReqVo;
import com.example.springboottpl.vo.req.UserDeleteReqVo;
import com.example.springboottpl.vo.req.UserUpdateReqVo;
import com.example.springboottpl.vo.resp.UserRespVo;
import com.example.springboottpl.biz.UserBiz;
import com.example.springboottpl.service.UserService;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserBiz userBiz;

   /**
    * 添加用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int saveUser(UserAddReqVo user){

        return userBiz.saveUser(user);
   }

   /**
    * 删除用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int deleteUser(UserDeleteReqVo user){
		return userBiz.deleteUser(user);
   }

   /**
    * 更新用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int updateUser(UserUpdateReqVo user){

        return userBiz.updateUser(user);
   }

   /**
    * 查询用户信息
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public UserRespVo queryUser(UserReqVo user){

       return userBiz.queryUser(user);
   }

   /**
    * 查询用户信息列表
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public ResultPage<UserRespVo> queryUserList(UserListReqVo user){

        return userBiz.queryUserList(user);
   }

}