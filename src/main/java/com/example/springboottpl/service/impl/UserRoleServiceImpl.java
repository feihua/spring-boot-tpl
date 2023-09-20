package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserRoleReqVo;
import com.example.springboottpl.vo.req.UserRoleListReqVo;
import com.example.springboottpl.vo.req.UserRoleAddReqVo;
import com.example.springboottpl.vo.req.UserRoleDeleteReqVo;
import com.example.springboottpl.vo.req.UserRoleUpdateReqVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;
import com.example.springboottpl.biz.UserRoleBiz;
import com.example.springboottpl.service.UserRoleService;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

   @Autowired
   private UserRoleBiz userRoleBiz;

   /**
    * 添加角色用户关联表
    *
    * @param userRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int saveUserRole(UserRoleAddReqVo userRole){

        return userRoleBiz.saveUserRole(userRole);
   }

   /**
    * 删除角色用户关联表
    *
    * @param userRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int deleteUserRole(UserRoleDeleteReqVo userRole){
		return userRoleBiz.deleteUserRole(userRole);
   }

   /**
    * 更新角色用户关联表
    *
    * @param userRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int updateUserRole(UserRoleUpdateReqVo userRole){

        return userRoleBiz.updateUserRole(userRole);
   }

   /**
    * 查询角色用户关联表
    *
    * @param userRole 请求参数
    * @return UserRoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public UserRoleRespVo queryUserRole(UserRoleReqVo userRole){

       return userRoleBiz.queryUserRole(userRole);
   }

   /**
    * 查询角色用户关联表列表
    *
    * @param userRole 请求参数
    * @return UserRoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public ResultPage<UserRoleRespVo> queryUserRoleList(UserRoleListReqVo userRole){

        return userRoleBiz.queryUserRoleList(userRole);
   }

}