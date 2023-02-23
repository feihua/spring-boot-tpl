package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleUserReq;
import com.example.springboottpl.vo.req.RoleUserListReq;
import com.example.springboottpl.vo.req.RoleUserAddReq;
import com.example.springboottpl.vo.req.RoleUserUpdateReq;
import com.example.springboottpl.vo.resp.RoleUserResp;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:28
 */
public interface RoleUserService {

   /**
    * 查询角色用户关联表
    *
    * @param roleUser 请求参数
    * @return RoleUserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   RoleUserResp query(RoleUserReq roleUser);

   /**
    * 查询角色用户关联表列表
    *
    * @param roleUser 请求参数
    * @return ResultPage<RoleUserResp>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   ResultPage<RoleUserResp> queryRoleUserList(RoleUserListReq roleUser);

   /**
    * 添加角色用户关联表
    *
    * @param roleUser 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   int insert(RoleUserAddReq roleUser);

   /**
    * 删除角色用户关联表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   int delete(String ids);

   /**
    * 更新角色用户关联表
    *
    * @param roleUser 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   int update(RoleUserUpdateReq roleUser);

}