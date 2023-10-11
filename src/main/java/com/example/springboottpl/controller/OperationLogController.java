package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.service.OperationLogService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.OperationLogAddReqVo;
import com.example.springboottpl.vo.req.OperationLogDeleteReqVo;
import com.example.springboottpl.vo.req.OperationLogListReqVo;
import com.example.springboottpl.vo.resp.OperationLogRespVo;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
 */
@Api(tags = "操作日志")
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {

   @Autowired
   private OperationLogService operationLogService;

   /**
    * 添加操作日志
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   @ApiOperation("添加操作日志")
   @PostMapping("/saveOperationLog")
   public Result<Integer> saveOperationLog(@RequestBody @Valid OperationLogAddReqVo record){
        return Result.success(operationLogService.saveOperationLog(record));
   }

   /**
    * 删除操作日志
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   @ApiOperation("删除操作日志")
   @DeleteMapping("/deleteOperationLog")
   public Result<Integer> deleteOperationLog(@RequestBody @Valid OperationLogDeleteReqVo record){
        return Result.success(operationLogService.deleteOperationLog(record));
   }

   /**
    * 查询操作日志列表
    *
    * @param record 请求参数
    * @return OperationLogResp
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   @ApiOperation("查询操作日志列表")
   @PostMapping("/queryOperationLogList")
   public Result<ResultPage<OperationLogRespVo>> queryOperationLogList(@RequestBody @Valid OperationLogListReqVo record){
        return Result.success(operationLogService.queryOperationLogList(record));
   }

}
