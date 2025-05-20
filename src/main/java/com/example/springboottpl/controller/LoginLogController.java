package com.example.springboottpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.LoginLogService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.DeleteLoginLogReqVo;
import com.example.springboottpl.vo.req.QueryLoginLogDetailReqVo;
import com.example.springboottpl.vo.req.QueryLoginLogListReqVo;
import com.example.springboottpl.vo.resp.QueryLoginLogDetailRespVo;
import com.example.springboottpl.vo.resp.QueryLoginLogListRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "9.1.访问记录")
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

   @Autowired
   private LoginLogService loginLogService;

   /**
    * 删除系统访问记录
    *
    * @param loginLog 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 1)
   @Operation(summary = "1.1 删除系统访问记录")
   @PostMapping("/deleteLoginLog")
   @OperateLog(description = "【系统访问记录】删除系统访问记录")
   public Result<Integer> deleteLoginLog(@RequestBody @Valid DeleteLoginLogReqVo loginLog){
        return loginLogService.deleteLoginLog(loginLog);
   }

   /**
    * 清空系统访问记录
    *
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 2)
   @Operation(summary = "1.2 清空系统访问记录")
   @PostMapping("/cleanLoginLog")
   @OperateLog(description = "【系统访问记录】清空系统访问记录")
   public Result<Integer> cleanLoginLog() {
       return loginLogService.cleanLoginLog();
   }

   /**
    * 查询系统访问记录详情
    *
    * @param loginLog 请求参数
    * @return LoginLogResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 3)
   @Operation(summary = "1.3 查询系统访问记录详情")
   @PostMapping("/queryLoginLogDetail")
   public Result<QueryLoginLogDetailRespVo> queryLoginLogDetail(@RequestBody @Valid QueryLoginLogDetailReqVo loginLog){
       return loginLogService.queryLoginLogDetail(loginLog);
   }

   /**
    * 查询系统访问记录列表
    *
    * @param loginLog 请求参数
    * @return LoginLogResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 4)
   @Operation(summary = "1.4 查询系统访问记录列表")
   @PostMapping("/queryLoginLogList")
   public Result<ResultPage<QueryLoginLogListRespVo>> queryLoginLogList(@RequestBody @Valid QueryLoginLogListReqVo loginLog){
        return loginLogService.queryLoginLogList(loginLog);
   }

}
