package com.example.tpl.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.OperationLogBiz;
import com.example.tpl.system.service.OperationLogService;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddOperationLogReqVo;
import com.example.tpl.system.vo.req.DeleteOperationLogReqVo;
import com.example.tpl.system.vo.req.QueryOperationLogDetailReqVo;
import com.example.tpl.system.vo.req.QueryOperationLogListReqVo;
import com.example.tpl.system.vo.resp.QueryOperationLogDetailRespVo;
import com.example.tpl.system.vo.resp.QueryOperationLogListRespVo;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogBiz operationLogBiz;

    /**
     * 添加操作日志
     *
     * @param operationLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<Integer> addOperationLog(AddOperationLogReqVo operationLog) {

        return operationLogBiz.addOperationLog(operationLog);
    }

    /**
     * 删除操作日志
     *
     * @param operationLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<Integer> deleteOperationLog(DeleteOperationLogReqVo operationLog) {
        return operationLogBiz.deleteOperationLog(operationLog);
    }

    /**
     * 清空操作日志
     *
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/10 16:00:47
     */
    @Override
    public Result<Integer> cleanOperationLog() {
        return operationLogBiz.cleanOperationLog();
    }

    /**
     * 查询操作日志详情
     *
     * @param operationLog 请求参数
     * @return OperationLogResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<QueryOperationLogDetailRespVo> queryOperationLogDetail(QueryOperationLogDetailReqVo operationLog) {

        return operationLogBiz.queryOperationLogDetail(operationLog);
    }

    /**
     * 查询操作日志列表
     *
     * @param operationLog 请求参数
     * @return OperationLogResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<ResultPage<QueryOperationLogListRespVo>> queryOperationLogList(QueryOperationLogListReqVo operationLog) {

        return operationLogBiz.queryOperationLogList(operationLog);
    }

}