package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleReq;
import com.example.springboottpl.vo.req.RoleListReq;
import com.example.springboottpl.vo.req.RoleAddReq;
import com.example.springboottpl.vo.req.RoleUpdateReq;
import com.example.springboottpl.vo.resp.RoleResp;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:29
 */
public interface RoleService {

   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   RoleResp query(RoleReq role);

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return ResultPage<RoleResp>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   ResultPage<RoleResp> queryRoleList(RoleListReq role);

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   int insert(RoleAddReq role);

   /**
    * 删除角色信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   int delete(String ids);

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   int update(RoleUpdateReq role);

}