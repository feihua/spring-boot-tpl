package com.example.springboottpl.biz;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserRoleAddReqVo;
import com.example.springboottpl.vo.req.UserRoleListReqVo;
import com.example.springboottpl.vo.req.UserRoleReqVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
public interface UserRoleBiz {

   /**
    * 添加角色用户关联表
    *
    * @param userRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int saveUserRole(UserRoleAddReqVo userRole);

   /**
    * 删除角色用户关联表
    *
    * @param userId 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int deleteUserRole(Integer userId);


   /**
    * 查询角色用户关联表
    *
    * @param userRole 请求参数
    * @return UserRoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   UserRoleRespVo queryUserRole(UserRoleReqVo userRole);

   /**
    * 查询角色用户关联表列表
    *
    * @param userRole 请求参数
    * @return ResultPage<UserRoleResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   ResultPage<UserRoleRespVo> queryUserRoleList(UserRoleListReqVo userRole);


   /**
    * 查询用户是否是管理员
    *
    * @param userId 用户id
    * @param roleId 角色id
    * @return boolean
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   boolean queryIsAdmin(int userId, int roleId);
}