package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.OperationLogBiz;
import com.example.springboottpl.dao.OperationLogDao;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.OperationLogAddReqVo;
import com.example.springboottpl.vo.req.OperationLogDeleteReqVo;
import com.example.springboottpl.vo.req.OperationLogListReqVo;
import com.example.springboottpl.vo.resp.OperationLogRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
 */
@Service
public class OperationLogBizImpl implements OperationLogBiz {

   @Autowired
   private OperationLogDao operationLogDao;

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
        OperationLogBean bean = new OperationLogBean();
        bean.setUserId(operationLog.getUserId());
        bean.setUserName(operationLog.getUserName());
        bean.setIpAddress(operationLog.getIpAddress());
        bean.setOperationUrl(operationLog.getOperationUrl());
        bean.setOperationMethod(operationLog.getOperationMethod());
        bean.setOperationDesc(operationLog.getOperationDesc());
        bean.setRequestParams(operationLog.getRequestParams());
        bean.setResponseParams(operationLog.getResponseParams());
        bean.setErrMessage(operationLog.getErrMessage());
        bean.setErrMessageDetail(operationLog.getErrMessageDetail());
        bean.setUseTime(operationLog.getUseTime());
        bean.setOperationStatus(operationLog.getOperationStatus());

        return operationLogDao.saveOperationLog(bean);
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
		return operationLogDao.deleteOperationLog(operationLog.getIds());
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
        OperationLogBean bean = new OperationLogBean();
        bean.setUserId(operationLog.getUserId());
        bean.setUserName(operationLog.getUserName());
        bean.setIpAddress(operationLog.getIpAddress());
        bean.setOperationUrl(operationLog.getOperationUrl());
        bean.setOperationMethod(operationLog.getOperationMethod());
        bean.setOperationDesc(operationLog.getOperationDesc());
        bean.setOperationStatus(operationLog.getOperationStatus());

        PageHelper.startPage(operationLog.getPageNo(), operationLog.getPageSize());
	    List<OperationLogBean> query = operationLogDao.queryOperationLogList(bean);
        PageInfo<OperationLogBean> pageInfo = new PageInfo<>(query);

	    List<OperationLogRespVo> list = pageInfo.getList().stream().map(x -> {
            OperationLogRespVo resp = new OperationLogRespVo();
            resp.setId(x.getId());
            resp.setUserId(x.getUserId());
            resp.setUserName(x.getUserName());
            resp.setIpAddress(x.getIpAddress());
            resp.setOperationUrl(x.getOperationUrl());
            resp.setOperationMethod(x.getOperationMethod());
            resp.setOperationDesc(x.getOperationDesc());
            resp.setRequestParams(x.getRequestParams());
            resp.setResponseParams(x.getResponseParams());
            resp.setErrMessage(x.getErrMessage());
            resp.setErrMessageDetail(x.getErrMessageDetail());
            resp.setUseTime(x.getUseTime());
            resp.setCreateTime(x.getCreateTime());
            resp.setOperationStatus(x.getOperationStatus());
		   return resp;
	    }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
}