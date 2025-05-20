package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.OperationLogBiz;
import com.example.springboottpl.dao.OperationLogDao;
import com.example.springboottpl.entity.OperationLogBean;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddOperationLogReqVo;
import com.example.springboottpl.vo.req.DeleteOperationLogReqVo;
import com.example.springboottpl.vo.req.QueryOperationLogDetailReqVo;
import com.example.springboottpl.vo.req.QueryOperationLogListReqVo;
import com.example.springboottpl.vo.resp.QueryOperationLogDetailRespVo;
import com.example.springboottpl.vo.resp.QueryOperationLogListRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:35
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
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> addOperationLog(AddOperationLogReqVo operationLog) {
        OperationLogBean bean = new OperationLogBean();
        bean.setTitle(operationLog.getTitle()); //系统模块
        bean.setUserId(operationLog.getUserId()); //操作人员
        bean.setUserName(operationLog.getUserName()); //操作人员
        bean.setDeptId(operationLog.getDeptId()); //部门id
        bean.setDeptName(operationLog.getDeptName()); //部门名称
        bean.setPlatform(operationLog.getPlatform());//平台信息
        bean.setOs(operationLog.getOs());//操作系统
        bean.setBrowser(operationLog.getBrowser());//浏览器类型
        bean.setVersion(operationLog.getVersion());//浏览器版本
        bean.setEngine(operationLog.getEngine());//渲染引擎信息
        bean.setOperateIp(operationLog.getOperateIp()); //IP地址
        bean.setOperationUrl(operationLog.getOperationUrl()); //请求URL
        bean.setRequestMethod(operationLog.getRequestMethod()); //请求方式
        bean.setOperationDesc(operationLog.getOperationDesc()); //操作描述
        bean.setStatus(operationLog.getStatus()); //操作状态(0:异常,正常)
        bean.setOperateParam(operationLog.getOperateParam()); //请求参数
        bean.setJsonResult(operationLog.getJsonResult()); //操作结果
        bean.setErrorMsg(operationLog.getErrorMsg()); //异常消息
        bean.setErrMsgDetail(operationLog.getErrMsgDetail()); //详细的异常信息
        bean.setCostTime(operationLog.getCostTime()); //耗时
        bean.setOperateTime(operationLog.getOperateTime()); //操作时间

        int i = operationLogDao.addOperationLog(bean);
        return Result.success(i);
    }

    /**
     * 删除操作日志
     *
     * @param operationLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> deleteOperationLog(DeleteOperationLogReqVo operationLog) {
        int i = operationLogDao.deleteOperationLog(operationLog.getIds());
        return Result.success(i);
    }

    /**
     * 清空操作日志
     *
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> cleanOperationLog() {
        int i = operationLogDao.cleanOperationLog();
        return Result.success(i);
    }


    /**
     * 查询操作日志详情
     *
     * @param operationLog 请求参数
     * @return OperationLogResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<QueryOperationLogDetailRespVo> queryOperationLogDetail(QueryOperationLogDetailReqVo operationLog) {
        OperationLogBean bean = new OperationLogBean();
        bean.setId(operationLog.getId());

        //bean.setTitle(operationLog.getTitle());//系统模块
        //bean.setUserId(operationLog.getUserId());//操作人员
        //bean.setUserName(operationLog.getUserName());//操作人员
        //bean.setDeptId(operationLog.getDeptId());//部门id
        //bean.setDeptName(operationLog.getDeptName());//部门名称
        //bean.setOperateIp(operationLog.getOperateIp());//IP地址
        //bean.setOperationUrl(operationLog.getOperationUrl());//请求URL
        //bean.setRequestMethod(operationLog.getRequestMethod());//请求方式
        //bean.setOperationDesc(operationLog.getOperationDesc());//操作描述
        //bean.setStatus(operationLog.getStatus());//操作状态(0:异常,正常)
        //bean.setOperateParam(operationLog.getOperateParam());//请求参数
        //bean.setJsonResult(operationLog.getJsonResult());//操作结果
        //bean.setErrorMsg(operationLog.getErrorMsg());//异常消息
        //bean.setErrMsgDetail(operationLog.getErrMsgDetail());//详细的异常信息
        //bean.setCostTime(operationLog.getCostTime());//耗时
        //bean.setOperateTime(operationLog.getOperateTime());//操作时间

        OperationLogBean operationLogBean = operationLogDao.queryOperationLogDetail(bean);
        if (operationLogBean == null) {
            return Result.error("查询操作日志详情失败,操作日志不存在");
        }


        QueryOperationLogDetailRespVo resp = new QueryOperationLogDetailRespVo();
        resp.setId(operationLogBean.getId());//主键
        resp.setTitle(operationLogBean.getTitle());//系统模块
        resp.setUserId(operationLogBean.getUserId());//操作人员
        resp.setUserName(operationLogBean.getUserName());//操作人员
        resp.setDeptId(operationLogBean.getDeptId());//部门id
        resp.setDeptName(operationLogBean.getDeptName());//部门名称
        resp.setPlatform(operationLogBean.getPlatform());//平台信息
        resp.setOs(operationLogBean.getOs());//操作系统
        resp.setBrowser(operationLogBean.getBrowser());//浏览器类型
        resp.setVersion(operationLogBean.getVersion());//浏览器版本
        resp.setEngine(operationLogBean.getEngine());//渲染引擎信息
        resp.setOperateIp(operationLogBean.getOperateIp());//IP地址
        resp.setOperationUrl(operationLogBean.getOperationUrl());//请求URL
        resp.setRequestMethod(operationLogBean.getRequestMethod());//请求方式
        resp.setOperationDesc(operationLogBean.getOperationDesc());//操作描述
        resp.setStatus(operationLogBean.getStatus());//操作状态(0:异常,正常)
        resp.setOperateParam(operationLogBean.getOperateParam());//请求参数
        resp.setJsonResult(operationLogBean.getJsonResult());//操作结果
        resp.setErrorMsg(operationLogBean.getErrorMsg());//异常消息
        resp.setErrMsgDetail(operationLogBean.getErrMsgDetail());//详细的异常信息
        resp.setCostTime(operationLogBean.getCostTime());//耗时
        resp.setOperateTime(operationLogBean.getOperateTime());//操作时间

        return Result.success(resp);
    }

    /**
     * 查询操作日志列表
     *
     * @param operationLog 请求参数
     * @return OperationLogResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<ResultPage<QueryOperationLogListRespVo>> queryOperationLogList(QueryOperationLogListReqVo operationLog) {
        OperationLogBean bean = new OperationLogBean();
        bean.setUserId(operationLog.getUserId());
        bean.setUserName(operationLog.getUserName());
        bean.setStatus(operationLog.getOperationStatus());

        PageHelper.startPage(operationLog.getPageNo(), operationLog.getPageSize());
        List<OperationLogBean> query = operationLogDao.queryOperationLogList(bean);
        PageInfo<OperationLogBean> pageInfo = new PageInfo<>(query);


        List<QueryOperationLogListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryOperationLogListRespVo resp = new QueryOperationLogListRespVo();
            resp.setId(x.getId());//主键
            resp.setTitle(x.getTitle());//系统模块
            resp.setUserId(x.getUserId());//操作人员
            resp.setUserName(x.getUserName());//操作人员
            resp.setDeptId(x.getDeptId());//部门id
            resp.setDeptName(x.getDeptName());//部门名称
            resp.setPlatform(x.getPlatform());//平台信息
            resp.setOs(x.getOs());//操作系统
            resp.setBrowser(x.getBrowser());//浏览器类型
            resp.setVersion(x.getVersion());//浏览器版本
            resp.setEngine(x.getEngine());//渲染引擎信息
            resp.setOperateIp(x.getOperateIp());//IP地址
            resp.setOperationUrl(x.getOperationUrl());//请求URL
            resp.setRequestMethod(x.getRequestMethod());//请求方式
            resp.setOperationDesc(x.getOperationDesc());//操作描述
            resp.setStatus(x.getStatus());//操作状态(0:异常,正常)
            resp.setOperateParam(x.getOperateParam());//请求参数
            resp.setJsonResult(x.getJsonResult());//操作结果
            resp.setErrorMsg(x.getErrorMsg());//异常消息
            resp.setErrMsgDetail(x.getErrMsgDetail());//详细的异常信息
            resp.setCostTime(x.getCostTime());//耗时
            resp.setOperateTime(x.getOperateTime());//操作时间
            return resp;
        }).collect(Collectors.toList());

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));

    }
}