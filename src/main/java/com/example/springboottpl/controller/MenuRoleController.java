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
import com.example.springboottpl.vo.req.MenuRoleReq;
import com.example.springboottpl.vo.req.MenuRoleListReq;
import com.example.springboottpl.vo.req.MenuRoleAddReq;
import com.example.springboottpl.vo.req.MenuRoleUpdateReq;
import com.example.springboottpl.vo.resp.MenuRoleResp;
import com.example.springboottpl.service.MenuRoleService;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:31
 */
@Api(tags = "菜单角色关联表")
@RestController
@RequestMapping("/menuRole")
public class MenuRoleController {

   @Autowired
   private MenuRoleService menuRoleService;

   /**
    * 查询菜单角色关联表
    *
    * @param record 请求参数
    * @return MenuRoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @ApiOperation("查询菜单角色关联表")
   @PostMapping("/query")
   public MenuRoleResp query(@RequestBody @Valid MenuRoleReq record){
       return menuRoleService.query(record);
   }

   /**
    * 查询菜单角色关联表列表
    *
    * @param record 请求参数
    * @return MenuRoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @ApiOperation("查询菜单角色关联表列表")
   @PostMapping("/list")
   public Result<ResultPage<MenuRoleResp>> queryMenuRoleList(@RequestBody @Valid MenuRoleListReq record){
        return Result.success(menuRoleService.queryMenuRoleList(record));
   }
   /**
    * 添加菜单角色关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @ApiOperation("添加菜单角色关联表")
   @PostMapping("/add")
   public Result<Integer> insert(@RequestBody @Valid MenuRoleAddReq record){
        return Result.success(menuRoleService.insert(record));
   }
   /**
    * 删除菜单角色关联表
    *
    * @param ids 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @ApiOperation("删除菜单角色关联表")
   @PostMapping("/delete")
   public Result<Integer> delete(String ids){
        return Result.success(menuRoleService.delete(ids));
   }
   /**
    * 更新菜单角色关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @ApiOperation("更新菜单角色关联表")
   @PostMapping("/update")
   public Result<Integer> update(@RequestBody @Valid MenuRoleUpdateReq record){
        return Result.success(menuRoleService.update(record));
   }

}