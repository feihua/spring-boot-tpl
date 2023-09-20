package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleReqVo;
import com.example.springboottpl.vo.req.RoleListReqVo;
import com.example.springboottpl.vo.req.RoleAddReqVo;
import com.example.springboottpl.vo.req.RoleDeleteReqVo;
import com.example.springboottpl.vo.req.RoleUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleRespVo;
import com.example.springboottpl.biz.RoleBiz;
import com.example.springboottpl.service.RoleService;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Service
public class RoleServiceImpl implements RoleService {

   @Autowired
   private RoleBiz roleBiz;

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int saveRole(RoleAddReqVo role){

        return roleBiz.saveRole(role);
   }

   /**
    * 删除角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int deleteRole(RoleDeleteReqVo role){
		return roleBiz.deleteRole(role);
   }

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int updateRole(RoleUpdateReqVo role){

        return roleBiz.updateRole(role);
   }

   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public RoleRespVo queryRole(RoleReqVo role){

       return roleBiz.queryRole(role);
   }

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public ResultPage<RoleRespVo> queryRoleList(RoleListReqVo role){

        return roleBiz.queryRoleList(role);
   }

}