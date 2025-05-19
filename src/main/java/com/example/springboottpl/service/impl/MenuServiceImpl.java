package com.example.springboottpl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.MenuBiz;
import com.example.springboottpl.service.MenuService;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
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
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> addMenu(AddMenuReqVo menu){

        return menuBiz.addMenu(menu);
   }

   /**
    * 删除菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> deleteMenu(DeleteMenuReqVo menu){
		return menuBiz.deleteMenu(menu);
   }

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> updateMenu(UpdateMenuReqVo menu){

        return menuBiz.updateMenu(menu);
   }

   /**
   * 更新菜单信息状态
   *
   * @param menu 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2025/01/13 17:57:36
   */
  @Override
  public Result<Integer> updateMenuStatus(UpdateMenuStatusReqVo menu){

       return menuBiz.updateMenuStatus(menu);
  }

   /**
    * 查询菜单信息详情
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<QueryMenuDetailRespVo> queryMenuDetail(QueryMenuDetailReqVo menu){

       return menuBiz.queryMenuDetail(menu);
   }

   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<List<QueryMenuListRespVo>> queryMenuList(QueryMenuListReqVo menu){

        return menuBiz.queryMenuList(menu);
   }

    /**
     * 查询菜单信息(排除按钮)
     *
     * @return List
     * @author 刘飞华
     * @date: 2025/1/20 9:10
     */
    @Override
    public Result<List<QueryMenuSimpleListRespVo>> queryMenuListSimple() {
        return menuBiz.queryMenuListSimple();
    }
}