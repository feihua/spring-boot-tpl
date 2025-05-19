package com.example.springboottpl.biz;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddOperationLogReqVo;
import com.example.springboottpl.vo.req.DeleteOperationLogReqVo;
import com.example.springboottpl.vo.req.QueryOperationLogDetailReqVo;
import com.example.springboottpl.vo.req.QueryOperationLogListReqVo;
import com.example.springboottpl.vo.resp.QueryOperationLogDetailRespVo;
import com.example.springboottpl.vo.resp.QueryOperationLogListRespVo;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface OperationLogBiz {

   /**
    * 添加操作日志
    *
    * @param operationLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addOperationLog(AddOperationLogReqVo operationLog);

   /**
    * 删除操作日志
    *
    * @param operationLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteOperationLog(DeleteOperationLogReqVo operationLog);

   /**
    /**
    * 清空操作日志
    *
    * @return int
    * @author 刘飞华
    * @date: 2025/01/10 15:34:35
    */
   Result<Integer> cleanOperationLog();


   /**
    * 查询操作日志详情
    *
    * @param operationLog 请求参数
    * @return OperationLogResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryOperationLogDetailRespVo> queryOperationLogDetail(QueryOperationLogDetailReqVo operationLog);

   /**
    * 查询操作日志列表
    *
    * @param operationLog 请求参数
    * @return ResultPage<OperationLogResp>
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<ResultPage<QueryOperationLogListRespVo>> queryOperationLogList(QueryOperationLogListReqVo operationLog);

}