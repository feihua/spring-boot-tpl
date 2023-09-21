package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.RoleMenuBean;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Mapper
public interface RoleMenuDao {

   /**
    * 添加菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int saveRoleMenu(RoleMenuBean roleMenu);

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
    * 更新菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int updateRoleMenu(RoleMenuBean roleMenu);

   /**
    * 查询菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return RoleMenu
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   RoleMenuBean queryRoleMenu(RoleMenuBean roleMenu);

   /**
    * 查询菜单角色关联表列表
    *
    * @param roleMenu 请求参数
    * @return List<RoleMenu>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   List<RoleMenuBean> queryRoleMenuList(RoleMenuBean roleMenu);

}
