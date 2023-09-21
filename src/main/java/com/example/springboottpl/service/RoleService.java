package com.example.springboottpl.service;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleAddReqVo;
import com.example.springboottpl.vo.req.RoleDeleteReqVo;
import com.example.springboottpl.vo.req.RoleListReqVo;
import com.example.springboottpl.vo.req.RoleReqVo;
import com.example.springboottpl.vo.req.RoleUpdateReqVo;
import com.example.springboottpl.vo.req.UpdateRoleMenuListReqVo;
import com.example.springboottpl.vo.resp.RoleMenuRespVo;
import com.example.springboottpl.vo.resp.RoleRespVo;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
public interface RoleService {

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int saveRole(RoleAddReqVo role);

   /**
    * 删除角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int deleteRole(RoleDeleteReqVo role);

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int updateRole(RoleUpdateReqVo role);

   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   RoleRespVo queryRole(RoleReqVo role);

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return ResultPage<RoleResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   ResultPage<RoleRespVo> queryRoleList(RoleListReqVo role);

   /**
    * 查询角色菜单信息列表
    *
    * @param roleId 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   RoleMenuRespVo queryRoleMenuList(Integer roleId);

   /**
    * 更新角色菜单信息列表
    *
    * @param record 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   Integer updateRoleMenuList(UpdateRoleMenuListReqVo record);
}