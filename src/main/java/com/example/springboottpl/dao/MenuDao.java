package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboottpl.entity.MenuBean;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
@Mapper
public interface MenuDao {

   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   int saveMenu(MenuBean menu);

   /**
    * 删除菜单信息
    *
    * @param id 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   int deleteMenu(@Param("id") Integer id);

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   int updateMenu(MenuBean menu);

   /**
    * 查询菜单信息
    *
    * @param menu 请求参数
    * @return Menu
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   MenuBean queryMenu(MenuBean menu);

   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return List<Menu>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   List<MenuBean> queryMenuList(MenuBean menu);

}
