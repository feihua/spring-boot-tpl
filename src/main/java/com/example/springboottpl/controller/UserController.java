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
import com.example.springboottpl.vo.req.UserReq;
import com.example.springboottpl.vo.req.UserListReq;
import com.example.springboottpl.vo.req.UserAddReq;
import com.example.springboottpl.vo.req.UserUpdateReq;
import com.example.springboottpl.vo.resp.UserResp;
import com.example.springboottpl.service.UserService;

/**
 * 描述：后台用户信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:26
 */
@Api(tags = "后台用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   /**
    * 查询后台用户信息
    *
    * @param record 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @ApiOperation("查询后台用户信息")
   @PostMapping("/query")
   public UserResp query(@RequestBody @Valid UserReq record){
       return userService.query(record);
   }

   /**
    * 查询后台用户信息列表
    *
    * @param record 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @ApiOperation("查询后台用户信息列表")
   @PostMapping("/list")
   public Result<ResultPage<UserResp>> queryUserList(@RequestBody @Valid UserListReq record){
        return Result.success(userService.queryUserList(record));
   }
   /**
    * 添加后台用户信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @ApiOperation("添加后台用户信息")
   @PostMapping("/add")
   public Result<Integer> insert(@RequestBody @Valid UserAddReq record){
        return Result.success(userService.insert(record));
   }
   /**
    * 删除后台用户信息
    *
    * @param ids 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @ApiOperation("删除后台用户信息")
   @PostMapping("/delete")
   public Result<Integer> delete(String ids){
        return Result.success(userService.delete(ids));
   }
   /**
    * 更新后台用户信息
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @ApiOperation("更新后台用户信息")
   @PostMapping("/update")
   public Result<Integer> update(@RequestBody @Valid UserUpdateReq record){
        return Result.success(userService.update(record));
   }

}