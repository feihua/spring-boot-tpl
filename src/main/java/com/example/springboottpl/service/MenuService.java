package com.example.springboottpl.service;

import java.util.List;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.vo.req.AddMenuReqVo;
import com.example.springboottpl.vo.req.DeleteMenuReqVo;
import com.example.springboottpl.vo.req.QueryMenuDetailReqVo;
import com.example.springboottpl.vo.req.QueryMenuListReqVo;
import com.example.springboottpl.vo.req.UpdateMenuReqVo;
import com.example.springboottpl.vo.req.UpdateMenuStatusReqVo;
import com.example.springboottpl.vo.resp.QueryMenuDetailRespVo;
import com.example.springboottpl.vo.resp.QueryMenuListRespVo;
import com.example.springboottpl.vo.resp.QueryMenuSimpleListRespVo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface MenuService {

   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addMenu(AddMenuReqVo menu);

   /**
    * 删除菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteMenu(DeleteMenuReqVo menu);

   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateMenu(UpdateMenuReqVo menu);

   /**
    * 更新菜单信息状态
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateMenuStatus(UpdateMenuStatusReqVo menu);


   /**
    * 查询菜单信息详情
    *
    * @param menu 请求参数
    * @return QueryMenuDetailResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryMenuDetailRespVo> queryMenuDetail(QueryMenuDetailReqVo menu);

   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return QueryMenuListResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<List<QueryMenuListRespVo>> queryMenuList(QueryMenuListReqVo menu);

   /**查询菜单信息(排除按钮)
    *
    * @return List
    * @author 刘飞华
    * @date: 2025/1/20 9:10
    */
    Result<List<QueryMenuSimpleListRespVo>> queryMenuListSimple();

}