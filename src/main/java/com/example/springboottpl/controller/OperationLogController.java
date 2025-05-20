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
import com.example.springboottpl.service.OperationLogService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.DeleteOperationLogReqVo;
import com.example.springboottpl.vo.req.QueryOperationLogDetailReqVo;
import com.example.springboottpl.vo.req.QueryOperationLogListReqVo;
import com.example.springboottpl.vo.resp.QueryOperationLogDetailRespVo;
import com.example.springboottpl.vo.resp.QueryOperationLogListRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "9.2.操作日志")
@RestController
@RequestMapping("/operateLog")
public class OperationLogController {

    @Autowired
    private OperationLogService operationLogService;

    /**
     * 删除操作日志
     *
     * @param operationLog 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "1.1 删除操作日志")
    @PostMapping("/deleteOperateLog")
    @OperateLog(description = "【操作日志】删除操作日志")
    public Result<Integer> deleteOperationLog(@RequestBody @Valid DeleteOperationLogReqVo operationLog) {
        return operationLogService.deleteOperationLog(operationLog);
    }

    /**
     * 清空操作日志
     *
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "1.2清空操作日志")
    @PostMapping("/cleanOperateLog")
    @OperateLog(description = "【操作日志】清空操作日志")
    public Result<Integer> cleanOperationLog() {
        return operationLogService.cleanOperationLog();
    }

    /**
     * 查询操作日志详情
     *
     * @param operationLog 请求参数
     * @return OperationLogResp
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "1.3 查询操作日志详情")
    @PostMapping("/queryOperateLogDetail")
    public Result<QueryOperationLogDetailRespVo> queryOperationLogDetail(@RequestBody @Valid QueryOperationLogDetailReqVo operationLog) {
        return operationLogService.queryOperationLogDetail(operationLog);
    }

    /**
     * 查询操作日志列表
     *
     * @param operationLog 请求参数
     * @return OperationLogResp
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "1.4 查询操作日志列表")
    @PostMapping("/queryOperateLogList")
    public Result<ResultPage<QueryOperationLogListRespVo>> queryOperationLogList(@RequestBody @Valid QueryOperationLogListReqVo operationLog) {
        return operationLogService.queryOperationLogList(operationLog);
    }

}
