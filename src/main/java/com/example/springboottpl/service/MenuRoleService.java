package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.MenuRoleReq;
import com.example.springboottpl.vo.req.MenuRoleListReq;
import com.example.springboottpl.vo.req.MenuRoleAddReq;
import com.example.springboottpl.vo.req.MenuRoleUpdateReq;
import com.example.springboottpl.vo.resp.MenuRoleResp;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:31
 */
public interface MenuRoleService {

   /**
    * 查询菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return MenuRoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   MenuRoleResp query(MenuRoleReq menuRole);

   /**
    * 查询菜单角色关联表列表
    *
    * @param menuRole 请求参数
    * @return ResultPage<MenuRoleResp>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   ResultPage<MenuRoleResp> queryMenuRoleList(MenuRoleListReq menuRole);

   /**
    * 添加菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   int insert(MenuRoleAddReq menuRole);

   /**
    * 删除菜单角色关联表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   int delete(String ids);

   /**
    * 更新菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   int update(MenuRoleUpdateReq menuRole);

}