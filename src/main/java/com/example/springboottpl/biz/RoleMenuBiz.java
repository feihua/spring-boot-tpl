package com.example.springboottpl.biz;

import java.util.List;

import com.example.springboottpl.vo.req.RoleMenuAddReqVo;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
public interface RoleMenuBiz {

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
    * @param roleId 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int deleteRoleMenu(Integer roleId);


   /**
    * 查询菜单角色关联表列表
    *
    * @param roleId 请求参数
    * @return ResultPage<RoleMenuResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   List<Integer> queryRoleMenuList(Integer roleId);

}