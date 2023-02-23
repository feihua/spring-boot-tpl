package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.MenuRole;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:31
 */
@Mapper
public interface MenuRoleDao {

   /**
    * 查询菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return MenuRole
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   MenuRole query(MenuRole menuRole);

   /**
    * 查询菜单角色关联表列表
    *
    * @param menuRole 请求参数
    * @return List<MenuRole>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   List<MenuRole> queryMenuRoleList(MenuRole menuRole);

   /**
    * 添加菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   int insert(MenuRole menuRole);

   /**
    * 删除菜单角色关联表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   int delete(List<Integer> ids);

   /**
    * 更新菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   int update(MenuRole menuRole);

}