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
import com.example.springboottpl.vo.req.LoginLogReqVo;
import com.example.springboottpl.vo.req.LoginLogListReqVo;
import com.example.springboottpl.vo.req.LoginLogAddReqVo;
import com.example.springboottpl.vo.req.LoginLogDeleteReqVo;
import com.example.springboottpl.vo.req.LoginLogUpdateReqVo;
import com.example.springboottpl.vo.resp.LoginLogRespVo;
import com.example.springboottpl.service.LoginLogService;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:59:01
 */
@Api(tags = "登录日志")
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

   @Autowired
   private LoginLogService loginLogService;

   /**
    * 添加登录日志
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   @ApiOperation("添加登录日志")
   @PostMapping("/saveLoginLog")
   public Result<Integer> saveLoginLog(@RequestBody @Valid LoginLogAddReqVo record){
        return Result.success(loginLogService.saveLoginLog(record));
   }

   /**
    * 删除登录日志
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   @ApiOperation("删除登录日志")
   @PostMapping("/deleteLoginLog")
   public Result<Integer> deleteLoginLog(@RequestBody @Valid LoginLogDeleteReqVo record){
        return Result.success(loginLogService.deleteLoginLog(record));
   }

   /**
    * 查询登录日志列表
    *
    * @param record 请求参数
    * @return LoginLogResp
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   @ApiOperation("查询登录日志列表")
   @PostMapping("/queryLoginLogList")
   public Result<ResultPage<LoginLogRespVo>> queryLoginLogList(@RequestBody @Valid LoginLogListReqVo record){
        return Result.success(loginLogService.queryLoginLogList(record));
   }

}
