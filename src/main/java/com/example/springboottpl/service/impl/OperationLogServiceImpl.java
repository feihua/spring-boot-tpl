package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.OperationLogReqVo;
import com.example.springboottpl.vo.req.OperationLogListReqVo;
import com.example.springboottpl.vo.req.OperationLogAddReqVo;
import com.example.springboottpl.vo.req.OperationLogDeleteReqVo;
import com.example.springboottpl.vo.req.OperationLogUpdateReqVo;
import com.example.springboottpl.vo.resp.OperationLogRespVo;
import com.example.springboottpl.biz.OperationLogBiz;
import com.example.springboottpl.service.OperationLogService;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
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
    * @date: 2023-09-22 09:54:29
    */
   @Override
   public int saveOperationLog(OperationLogAddReqVo operationLog){

        return operationLogBiz.saveOperationLog(operationLog);
   }

   /**
    * 删除操作日志
    *
    * @param operationLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   @Override
   public int deleteOperationLog(OperationLogDeleteReqVo operationLog){
		return operationLogBiz.deleteOperationLog(operationLog);
   }



   /**
    * 查询操作日志列表
    *
    * @param operationLog 请求参数
    * @return OperationLogResp
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   @Override
   public ResultPage<OperationLogRespVo> queryOperationLogList(OperationLogListReqVo operationLog){

        return operationLogBiz.queryOperationLogList(operationLog);
   }

}