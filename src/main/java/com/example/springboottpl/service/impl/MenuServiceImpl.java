package com.example.springboottpl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.MenuReqVo;
import com.example.springboottpl.vo.req.MenuAddReqVo;
import com.example.springboottpl.vo.req.MenuDeleteReqVo;
import com.example.springboottpl.vo.req.MenuUpdateReqVo;
import com.example.springboottpl.vo.resp.MenuRespVo;
import com.example.springboottpl.biz.MenuBiz;
import com.example.springboottpl.service.MenuService;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
@Service
public class MenuServiceImpl implements MenuService {

   @Autowired
   private MenuBiz menuBiz;

   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @Override
   public int saveMenu(MenuAddReqVo menu){

        return menuBiz.saveMenu(menu);
   }

   /**
    * 删除菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @Override
   public int deleteMenu(MenuDeleteReqVo menu){
		return menuBiz.deleteMenu(menu);
   }

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @Override
   public int updateMenu(MenuUpdateReqVo menu){

        return menuBiz.updateMenu(menu);
   }

   /**
    * 查询菜单信息
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @Override
   public MenuRespVo queryMenu(MenuReqVo menu){

       return menuBiz.queryMenu(menu);
   }

   /**
    * 查询菜单信息列表
    *
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @Override
   public List<MenuRespVo> queryMenuList(){

        return menuBiz.queryMenuList();
   }

}