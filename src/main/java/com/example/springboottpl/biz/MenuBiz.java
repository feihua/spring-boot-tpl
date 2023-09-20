package com.example.springboottpl.biz;

import java.util.List;

import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.vo.req.MenuReqVo;
import com.example.springboottpl.vo.req.MenuAddReqVo;
import com.example.springboottpl.vo.req.MenuDeleteReqVo;
import com.example.springboottpl.vo.req.MenuUpdateReqVo;
import com.example.springboottpl.vo.resp.MenuRespVo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
public interface MenuBiz {

   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   int saveMenu(MenuAddReqVo menu);

   /**
    * 删除菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   int deleteMenu(MenuDeleteReqVo menu);

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   int updateMenu(MenuUpdateReqVo menu);

   /**
    * 查询菜单信息
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   MenuRespVo queryMenu(MenuReqVo menu);

   /**
    * 查询菜单信息列表
    *
    * @return ResultPage<MenuResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   List<MenuRespVo> queryMenuList();

   /**
    * 查询菜单信息列表
    *
    * @return ResultPage<MenuResp>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   List<MenuBean> queryMenuListMenuBean();

}