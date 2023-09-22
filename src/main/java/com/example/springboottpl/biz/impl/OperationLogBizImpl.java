package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.OperationLogBean;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.OperationLogReqVo;
import com.example.springboottpl.vo.req.OperationLogListReqVo;
import com.example.springboottpl.vo.req.OperationLogAddReqVo;
import com.example.springboottpl.vo.req.OperationLogDeleteReqVo;
import com.example.springboottpl.vo.req.OperationLogUpdateReqVo;
import com.example.springboottpl.vo.resp.OperationLogRespVo;
import com.example.springboottpl.dao.OperationLogDao;
import com.example.springboottpl.biz.OperationLogBiz;
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
        bean.setCreateTime(new Date());

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

        PageHelper.startPage(operationLog.getPageNum(), operationLog.getPageSize());
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
            resp.setCreateTime(x.getCreateTime());
		   return resp;
	    }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
}