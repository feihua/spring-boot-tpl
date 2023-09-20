package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleMenuReqVo;
import com.example.springboottpl.vo.req.RoleMenuListReqVo;
import com.example.springboottpl.vo.req.RoleMenuAddReqVo;
import com.example.springboottpl.vo.req.RoleMenuDeleteReqVo;
import com.example.springboottpl.vo.req.RoleMenuUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleMenuRespVo;
import com.example.springboottpl.biz.RoleMenuBiz;
import com.example.springboottpl.service.RoleMenuService;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

   @Autowired
   private RoleMenuBiz roleMenuBiz;

   /**
    * 添加菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int saveRoleMenu(RoleMenuAddReqVo roleMenu){

        return roleMenuBiz.saveRoleMenu(roleMenu);
   }

   /**
    * 删除菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int deleteRoleMenu(RoleMenuDeleteReqVo roleMenu){
		return roleMenuBiz.deleteRoleMenu(roleMenu);
   }

   /**
    * 更新菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int updateRoleMenu(RoleMenuUpdateReqVo roleMenu){

        return roleMenuBiz.updateRoleMenu(roleMenu);
   }

   /**
    * 查询菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public RoleMenuRespVo queryRoleMenu(RoleMenuReqVo roleMenu){

       return roleMenuBiz.queryRoleMenu(roleMenu);
   }

   /**
    * 查询菜单角色关联表列表
    *
    * @param roleMenu 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public ResultPage<RoleMenuRespVo> queryRoleMenuList(RoleMenuListReqVo roleMenu){

        return roleMenuBiz.queryRoleMenuList(roleMenu);
   }

}