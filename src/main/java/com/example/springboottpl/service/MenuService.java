package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.MenuReq;
import com.example.springboottpl.vo.req.MenuListReq;
import com.example.springboottpl.vo.req.MenuAddReq;
import com.example.springboottpl.vo.req.MenuUpdateReq;
import com.example.springboottpl.vo.resp.MenuResp;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:32
 */
public interface MenuService {

   /**
    * 查询菜单信息
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   MenuResp query(MenuReq menu);

   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return ResultPage<MenuResp>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   ResultPage<MenuResp> queryMenuList(MenuListReq menu);

   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   int insert(MenuAddReq menu);

   /**
    * 删除菜单信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   int delete(String ids);

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   int update(MenuUpdateReq menu);

}