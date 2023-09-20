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
import com.example.springboottpl.vo.req.UserRoleReqVo;
import com.example.springboottpl.vo.req.UserRoleListReqVo;
import com.example.springboottpl.vo.req.UserRoleAddReqVo;
import com.example.springboottpl.vo.req.UserRoleDeleteReqVo;
import com.example.springboottpl.vo.req.UserRoleUpdateReqVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;
import com.example.springboottpl.service.UserRoleService;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Api(tags = "角色用户关联表")
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

   @Autowired
   private UserRoleService userRoleService;

   /**
    * 添加角色用户关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @ApiOperation("添加角色用户关联表")
   @PostMapping("/saveUserRole")
   public Result<Integer> saveUserRole(@RequestBody @Valid UserRoleAddReqVo record){
        return Result.success(userRoleService.saveUserRole(record));
   }

   /**
    * 删除角色用户关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @ApiOperation("删除角色用户关联表")
   @PostMapping("/deleteUserRole")
   public Result<Integer> deleteUserRole(@RequestBody @Valid UserRoleDeleteReqVo record){
        return Result.success(userRoleService.deleteUserRole(record));
   }

   /**
    * 更新角色用户关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @ApiOperation("更新角色用户关联表")
   @PostMapping("/updateUserRole")
   public Result<Integer> updateUserRole(@RequestBody @Valid UserRoleUpdateReqVo record){
        return Result.success(userRoleService.updateUserRole(record));
   }

   /**
    * 查询角色用户关联表
    *
    * @param record 请求参数
    * @return UserRoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @ApiOperation("查询角色用户关联表")
   @PostMapping("/queryUserRole")
   public UserRoleRespVo query(@RequestBody @Valid UserRoleReqVo record){
       return userRoleService.queryUserRole(record);
   }

   /**
    * 查询角色用户关联表列表
    *
    * @param record 请求参数
    * @return UserRoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @ApiOperation("查询角色用户关联表列表")
   @PostMapping("/queryUserRoleList")
   public Result<ResultPage<UserRoleRespVo>> queryUserRoleList(@RequestBody @Valid UserRoleListReqVo record){
        return Result.success(userRoleService.queryUserRoleList(record));
   }

}
