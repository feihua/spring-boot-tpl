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
import com.example.springboottpl.vo.req.MenuReq;
import com.example.springboottpl.vo.req.MenuListReq;
import com.example.springboottpl.vo.req.MenuAddReq;
import com.example.springboottpl.vo.req.MenuUpdateReq;
import com.example.springboottpl.vo.resp.MenuResp;
import com.example.springboottpl.service.MenuService;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:32
 */
@Api(tags = "菜单信息")
@RestController
@RequestMapping("/menu")
public class MenuController {

   @Autowired
   private MenuService menuService;

   /**
    * 查询菜单信息
    *
    * @param record 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @ApiOperation("查询菜单信息")
   @PostMapping("/query")
   public MenuResp query(@RequestBody @Valid MenuReq record){
       return menuService.query(record);
   }

   /**
    * 查询菜单信息列表
    *
    * @param record 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @ApiOperation("查询菜单信息列表")
   @PostMapping("/list")
   public Result<ResultPage<MenuResp>> queryMenuList(@RequestBody @Valid MenuListReq record){
        return Result.success(menuService.queryMenuList(record));
   }
   /**
    * 添加菜单信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @ApiOperation("添加菜单信息")
   @PostMapping("/add")
   public Result<Integer> insert(@RequestBody @Valid MenuAddReq record){
        return Result.success(menuService.insert(record));
   }
   /**
    * 删除菜单信息
    *
    * @param ids 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @ApiOperation("删除菜单信息")
   @PostMapping("/delete")
   public Result<Integer> delete(String ids){
        return Result.success(menuService.delete(ids));
   }
   /**
    * 更新菜单信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @ApiOperation("更新菜单信息")
   @PostMapping("/update")
   public Result<Integer> update(@RequestBody @Valid MenuUpdateReq record){
        return Result.success(menuService.update(record));
   }

}