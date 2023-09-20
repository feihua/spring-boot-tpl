package com.example.springboottpl.biz;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserLoginReqVo;
import com.example.springboottpl.vo.req.UserReqVo;
import com.example.springboottpl.vo.req.UserListReqVo;
import com.example.springboottpl.vo.req.UserAddReqVo;
import com.example.springboottpl.vo.req.UserDeleteReqVo;
import com.example.springboottpl.vo.req.UserRoleUpdateReqVo;
import com.example.springboottpl.vo.req.UserUpdateReqVo;
import com.example.springboottpl.vo.resp.UserLoginRespVo;
import com.example.springboottpl.vo.resp.UserMenuRespVo;
import com.example.springboottpl.vo.resp.UserRespVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
public interface UserBiz {

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

   /**
    * 用户登录
    *
    * @param record 请求参数
    * @return Result<UserLoginRespVo>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   UserLoginRespVo login(UserLoginReqVo record);

   /**
    * 查询用户菜单
    *
    * @param userId 请求参数
    * @return Result<UserLoginRespVo>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   UserMenuRespVo queryUserMenu(Integer userId);

   /**
    * 查询用户角色
    *
    * @param userId 请求参数
    * @return UserRoleRespVo
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
	UserRoleRespVo queryUserRole(Integer userId);

   /**
    * 更新用户角色
    *
    * @param record 请求参数
    * @return Integer
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   Integer updateUserRole(UserRoleUpdateReqVo record);


}