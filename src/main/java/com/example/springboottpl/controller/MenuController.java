package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.MenuService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.vo.req.MenuAddReqVo;
import com.example.springboottpl.vo.req.MenuDeleteReqVo;
import com.example.springboottpl.vo.req.MenuReqVo;
import com.example.springboottpl.vo.req.MenuUpdateReqVo;
import com.example.springboottpl.vo.resp.MenuRespVo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
@Api(tags = "菜单信息")
@RestController
@RequestMapping("/menu")
public class MenuController {

   @Autowired
   private MenuService menuService;

   /**
    * 添加菜单信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @ApiOperation("添加菜单信息")
   @PostMapping("/saveMenu")
   @OperateLog(description = "【菜单管理】添加菜单信息")
   public Result<Integer> saveMenu(@RequestBody @Valid MenuAddReqVo record){
        return Result.success(menuService.saveMenu(record));
   }

   /**
    * 删除菜单信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @ApiOperation("删除菜单信息")
   @DeleteMapping("/deleteMenu")
   @OperateLog(description = "【菜单管理】删除菜单信息")
   public Result<Integer> deleteMenu(@RequestBody @Valid MenuDeleteReqVo record){
        return Result.success(menuService.deleteMenu(record));
   }

   /**
    * 更新菜单信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @ApiOperation("更新菜单信息")
   @PutMapping("/updateMenu")
   @OperateLog(description = "【菜单管理】更新菜单信息")
   public Result<Integer> updateMenu(@RequestBody @Valid MenuUpdateReqVo record){
        return Result.success(menuService.updateMenu(record));
   }

   /**
    * 查询菜单信息
    *
    * @param record 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @ApiOperation("查询菜单信息")
   @PostMapping("/queryMenu")
   @OperateLog(description = "【菜单管理】查询菜单信息")
   public MenuRespVo query(@RequestBody @Valid MenuReqVo record){
       return menuService.queryMenu(record);
   }

   /**
    * 查询菜单信息列表
    *
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @ApiOperation("查询菜单信息列表")
   @PostMapping("/queryMenuList")
   @OperateLog(description = "【菜单管理】查询菜单信息列表")
   public Result<List<MenuRespVo>> queryMenuList(){
        return Result.success(menuService.queryMenuList());
   }

}
