package com.example.tpl.system.biz;

import java.util.List;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.vo.req.AddMenuReqVo;
import com.example.tpl.system.vo.req.DeleteMenuReqVo;
import com.example.tpl.system.vo.req.QueryMenuDetailReqVo;
import com.example.tpl.system.vo.req.QueryMenuListReqVo;
import com.example.tpl.system.vo.req.UpdateMenuReqVo;
import com.example.tpl.system.vo.req.UpdateMenuStatusReqVo;
import com.example.tpl.system.vo.resp.QueryMenuDetailRespVo;
import com.example.tpl.system.vo.resp.QueryMenuListRespVo;
import com.example.tpl.system.vo.resp.QueryMenuSimpleListRespVo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface MenuBiz {

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
    * @return MenuResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryMenuDetailRespVo> queryMenuDetail(QueryMenuDetailReqVo menu);

   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return ResultPage<MenuResp>
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