package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.OperationLogReqVo;
import com.example.springboottpl.vo.req.OperationLogListReqVo;
import com.example.springboottpl.vo.req.OperationLogAddReqVo;
import com.example.springboottpl.vo.req.OperationLogDeleteReqVo;
import com.example.springboottpl.vo.req.OperationLogUpdateReqVo;
import com.example.springboottpl.vo.resp.OperationLogRespVo;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
 */
public interface OperationLogService {

   /**
    * 添加操作日志
    *
    * @param operationLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   int saveOperationLog(OperationLogAddReqVo operationLog);

   /**
    * 删除操作日志
    *
    * @param operationLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   int deleteOperationLog(OperationLogDeleteReqVo operationLog);



   /**
    * 查询操作日志列表
    *
    * @param operationLog 请求参数
    * @return ResultPage<OperationLogResp>
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   ResultPage<OperationLogRespVo> queryOperationLogList(OperationLogListReqVo operationLog);

}