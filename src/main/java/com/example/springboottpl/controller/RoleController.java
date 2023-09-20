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
import com.example.springboottpl.vo.req.RoleReqVo;
import com.example.springboottpl.vo.req.RoleListReqVo;
import com.example.springboottpl.vo.req.RoleAddReqVo;
import com.example.springboottpl.vo.req.RoleDeleteReqVo;
import com.example.springboottpl.vo.req.RoleUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleRespVo;
import com.example.springboottpl.service.RoleService;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Api(tags = "角色信息")
@RestController
@RequestMapping("/role")
public class RoleController {

   @Autowired
   private RoleService roleService;

   /**
    * 添加角色信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("添加角色信息")
   @PostMapping("/saveRole")
   public Result<Integer> saveRole(@RequestBody @Valid RoleAddReqVo record){
        return Result.success(roleService.saveRole(record));
   }

   /**
    * 删除角色信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("删除角色信息")
   @PostMapping("/deleteRole")
   public Result<Integer> deleteRole(@RequestBody @Valid RoleDeleteReqVo record){
        return Result.success(roleService.deleteRole(record));
   }

   /**
    * 更新角色信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("更新角色信息")
   @PostMapping("/updateRole")
   public Result<Integer> updateRole(@RequestBody @Valid RoleUpdateReqVo record){
        return Result.success(roleService.updateRole(record));
   }

   /**
    * 查询角色信息
    *
    * @param record 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("查询角色信息")
   @PostMapping("/queryRole")
   public RoleRespVo query(@RequestBody @Valid RoleReqVo record){
       return roleService.queryRole(record);
   }

   /**
    * 查询角色信息列表
    *
    * @param record 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @ApiOperation("查询角色信息列表")
   @PostMapping("/queryRoleList")
   public Result<ResultPage<RoleRespVo>> queryRoleList(@RequestBody @Valid RoleListReqVo record){
        return Result.success(roleService.queryRoleList(record));
   }

}
