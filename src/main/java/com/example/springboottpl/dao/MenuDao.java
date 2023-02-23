package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.Menu;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:32
 */
@Mapper
public interface MenuDao {

   /**
    * 查询菜单信息
    *
    * @param menu 请求参数
    * @return Menu
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   Menu query(Menu menu);

   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return List<Menu>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   List<Menu> queryMenuList(Menu menu);

   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   int insert(Menu menu);

   /**
    * 删除菜单信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   int delete(List<Integer> ids);

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   int update(Menu menu);

}