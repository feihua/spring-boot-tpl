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
import com.example.springboottpl.vo.req.RoleReq;
import com.example.springboottpl.vo.req.RoleListReq;
import com.example.springboottpl.vo.req.RoleAddReq;
import com.example.springboottpl.vo.req.RoleUpdateReq;
import com.example.springboottpl.vo.resp.RoleResp;
import com.example.springboottpl.service.RoleService;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:29
 */
@Api(tags = "角色信息")
@RestController
@RequestMapping("/role")
public class RoleController {

   @Autowired
   private RoleService roleService;

   /**
    * 查询角色信息
    *
    * @param record 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @ApiOperation("查询角色信息")
   @PostMapping("/query")
   public RoleResp query(@RequestBody @Valid RoleReq record){
       return roleService.query(record);
   }

   /**
    * 查询角色信息列表
    *
    * @param record 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @ApiOperation("查询角色信息列表")
   @PostMapping("/list")
   public Result<ResultPage<RoleResp>> queryRoleList(@RequestBody @Valid RoleListReq record){
        return Result.success(roleService.queryRoleList(record));
   }
   /**
    * 添加角色信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @ApiOperation("添加角色信息")
   @PostMapping("/add")
   public Result<Integer> insert(@RequestBody @Valid RoleAddReq record){
        return Result.success(roleService.insert(record));
   }
   /**
    * 删除角色信息
    *
    * @param ids 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @ApiOperation("删除角色信息")
   @PostMapping("/delete")
   public Result<Integer> delete(String ids){
        return Result.success(roleService.delete(ids));
   }
   /**
    * 更新角色信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @ApiOperation("更新角色信息")
   @PostMapping("/update")
   public Result<Integer> update(@RequestBody @Valid RoleUpdateReq record){
        return Result.success(roleService.update(record));
   }

}