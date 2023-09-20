package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleMenuReqVo;
import com.example.springboottpl.vo.req.RoleMenuListReqVo;
import com.example.springboottpl.vo.req.RoleMenuAddReqVo;
import com.example.springboottpl.vo.req.RoleMenuDeleteReqVo;
import com.example.springboottpl.vo.req.RoleMenuUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleMenuRespVo;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
public interface RoleMenuService {

   /**
    * 添加菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int saveRoleMenu(RoleMenuAddReqVo roleMenu);

   /**
    * 删除菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int deleteRoleMenu(RoleMenuDeleteReqVo roleMenu);

   /**
    * 更新菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int updateRoleMenu(RoleMenuUpdateReqVo roleMenu);

   /**
    * 查询菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   RoleMenuRespVo queryRoleMenu(RoleMenuReqVo roleMenu);

   /**
    * 查询菜单角色关联表列表
    *
    * @param roleMenu 请求参数
    * @return ResultPage<RoleMenuResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   ResultPage<RoleMenuRespVo> queryRoleMenuList(RoleMenuListReqVo roleMenu);

}