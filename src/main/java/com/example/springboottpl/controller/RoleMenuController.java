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
import com.example.springboottpl.vo.req.RoleMenuReqVo;
import com.example.springboottpl.vo.req.RoleMenuListReqVo;
import com.example.springboottpl.vo.req.RoleMenuAddReqVo;
import com.example.springboottpl.vo.req.RoleMenuDeleteReqVo;
import com.example.springboottpl.vo.req.RoleMenuUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleMenuRespVo;
import com.example.springboottpl.service.RoleMenuService;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Api(tags = "菜单角色关联表")
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {

   @Autowired
   private RoleMenuService roleMenuService;

   /**
    * 添加菜单角色关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("添加菜单角色关联表")
   @PostMapping("/saveRoleMenu")
   public Result<Integer> saveRoleMenu(@RequestBody @Valid RoleMenuAddReqVo record){
        return Result.success(roleMenuService.saveRoleMenu(record));
   }

   /**
    * 删除菜单角色关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("删除菜单角色关联表")
   @PostMapping("/deleteRoleMenu")
   public Result<Integer> deleteRoleMenu(@RequestBody @Valid RoleMenuDeleteReqVo record){
        return Result.success(roleMenuService.deleteRoleMenu(record));
   }

   /**
    * 更新菜单角色关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("更新菜单角色关联表")
   @PostMapping("/updateRoleMenu")
   public Result<Integer> updateRoleMenu(@RequestBody @Valid RoleMenuUpdateReqVo record){
        return Result.success(roleMenuService.updateRoleMenu(record));
   }

   /**
    * 查询菜单角色关联表
    *
    * @param record 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("查询菜单角色关联表")
   @PostMapping("/queryRoleMenu")
   public RoleMenuRespVo query(@RequestBody @Valid RoleMenuReqVo record){
       return roleMenuService.queryRoleMenu(record);
   }

   /**
    * 查询菜单角色关联表列表
    *
    * @param record 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("查询菜单角色关联表列表")
   @PostMapping("/queryRoleMenuList")
   public Result<ResultPage<RoleMenuRespVo>> queryRoleMenuList(@RequestBody @Valid RoleMenuListReqVo record){
        return Result.success(roleMenuService.queryRoleMenuList(record));
   }

}
