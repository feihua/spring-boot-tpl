package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.MenuReqVo;
import com.example.springboottpl.vo.req.MenuListReqVo;
import com.example.springboottpl.vo.req.MenuAddReqVo;
import com.example.springboottpl.vo.req.MenuDeleteReqVo;
import com.example.springboottpl.vo.req.MenuUpdateReqVo;
import com.example.springboottpl.vo.resp.MenuRespVo;
import com.example.springboottpl.service.MenuService;

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
   @PostMapping("/deleteMenu")
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
   @PostMapping("/updateMenu")
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
   public MenuRespVo query(@RequestBody @Valid MenuReqVo record){
       return menuService.queryMenu(record);
   }

   /**
    * 查询菜单信息列表
    *
    * @param record 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:24
    */
   @ApiOperation("查询菜单信息列表")
   @PostMapping("/queryMenuList")
   public Result<ResultPage<MenuRespVo>> queryMenuList(@RequestBody @Valid MenuListReqVo record){
        return Result.success(menuService.queryMenuList(record));
   }

}
