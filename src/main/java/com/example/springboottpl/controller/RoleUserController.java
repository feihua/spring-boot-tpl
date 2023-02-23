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
import com.example.springboottpl.vo.req.RoleUserReq;
import com.example.springboottpl.vo.req.RoleUserListReq;
import com.example.springboottpl.vo.req.RoleUserAddReq;
import com.example.springboottpl.vo.req.RoleUserUpdateReq;
import com.example.springboottpl.vo.resp.RoleUserResp;
import com.example.springboottpl.service.RoleUserService;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:28
 */
@Api(tags = "角色用户关联表")
@RestController
@RequestMapping("/roleUser")
public class RoleUserController {

   @Autowired
   private RoleUserService roleUserService;

   /**
    * 查询角色用户关联表
    *
    * @param record 请求参数
    * @return RoleUserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @ApiOperation("查询角色用户关联表")
   @PostMapping("/query")
   public RoleUserResp query(@RequestBody @Valid RoleUserReq record){
       return roleUserService.query(record);
   }

   /**
    * 查询角色用户关联表列表
    *
    * @param record 请求参数
    * @return RoleUserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @ApiOperation("查询角色用户关联表列表")
   @PostMapping("/list")
   public Result<ResultPage<RoleUserResp>> queryRoleUserList(@RequestBody @Valid RoleUserListReq record){
        return Result.success(roleUserService.queryRoleUserList(record));
   }
   /**
    * 添加角色用户关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @ApiOperation("添加角色用户关联表")
   @PostMapping("/add")
   public Result<Integer> insert(@RequestBody @Valid RoleUserAddReq record){
        return Result.success(roleUserService.insert(record));
   }
   /**
    * 删除角色用户关联表
    *
    * @param ids 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @ApiOperation("删除角色用户关联表")
   @PostMapping("/delete")
   public Result<Integer> delete(String ids){
        return Result.success(roleUserService.delete(ids));
   }
   /**
    * 更新角色用户关联表
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @ApiOperation("更新角色用户关联表")
   @PostMapping("/update")
   public Result<Integer> update(@RequestBody @Valid RoleUserUpdateReq record){
        return Result.success(roleUserService.update(record));
   }

}