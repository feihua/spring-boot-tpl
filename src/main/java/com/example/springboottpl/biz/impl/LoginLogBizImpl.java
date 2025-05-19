package com.example.tpl.system.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.LoginLogBiz;
import com.example.tpl.system.dao.LoginLogDao;
import com.example.tpl.system.entity.LoginLogBean;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.DeleteLoginLogReqVo;
import com.example.tpl.system.vo.req.QueryLoginLogDetailReqVo;
import com.example.tpl.system.vo.req.QueryLoginLogListReqVo;
import com.example.tpl.system.vo.resp.QueryLoginLogDetailRespVo;
import com.example.tpl.system.vo.resp.QueryLoginLogListRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:35
 */
@Service
public class LoginLogBizImpl implements LoginLogBiz {

    @Autowired
    private LoginLogDao loginLogDao;


    /**
     * 删除系统访问记录
     *
     * @param loginLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> deleteLoginLog(DeleteLoginLogReqVo loginLog) {
        int i = loginLogDao.deleteLoginLog(loginLog.getIds());
        return Result.success(i);
    }

    /**
     * 清空系统访问记录
     *
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> cleanLoginLog() {
        int i = loginLogDao.cleanLoginLog();
        return Result.success(i);
    }

    /**
     * 查询系统访问记录详情
     *
     * @param loginLog 请求参数
     * @return LoginLogResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<QueryLoginLogDetailRespVo> queryLoginLogDetail(QueryLoginLogDetailReqVo loginLog) {
        LoginLogBean bean = new LoginLogBean();
        bean.setId(loginLog.getId());
        //bean.setLoginName(loginLog.getLoginName());//登录账号
        //bean.setIpaddr(loginLog.getIpaddr());//登录IP地址
        //bean.setLoginLocation(loginLog.getLoginLocation());//登录地点
        //bean.setPlatform(loginLog.getPlatform());//平台信息
        //bean.setBrowser(loginLog.getBrowser());//浏览器类型
        //bean.setVersion(loginLog.getVersion());//浏览器版本
        //bean.setOs(loginLog.getOs());//操作系统
        //bean.setArch(loginLog.getArch());//体系结构信息
        //bean.setEngine(loginLog.getEngine());//渲染引擎信息
        //bean.setStatus(loginLog.getStatus());//登录状态(0:失败,1:成功)
        //bean.setLoginTime(loginLog.getLoginTime());//访问时间

        LoginLogBean logBean = loginLogDao.queryLoginLogDetail(bean);
        if (logBean == null) {
            return Result.error("查询系统访问记录详情失败,不存在");
        }

        QueryLoginLogDetailRespVo resp = new QueryLoginLogDetailRespVo();
        resp.setId(logBean.getId());//访问ID
        resp.setLoginName(logBean.getLoginName());//登录账号
        resp.setIpaddr(logBean.getIpaddr());//登录IP地址
        resp.setLoginLocation(logBean.getLoginLocation());//登录地点
        resp.setPlatform(logBean.getPlatform());//平台信息
        resp.setBrowser(logBean.getBrowser());//浏览器类型
        resp.setVersion(logBean.getVersion());//浏览器版本
        resp.setOs(logBean.getOs());//操作系统
        resp.setArch(logBean.getArch());//体系结构信息
        resp.setEngine(logBean.getEngine());//渲染引擎信息
        resp.setEngineDetails(logBean.getEngineDetails());//渲染引擎详细信息
        resp.setExtra(logBean.getExtra());//其他信息（可选）
        resp.setStatus(logBean.getStatus());//登录状态(0:失败,1:成功)
        resp.setMsg(logBean.getMsg());//提示消息
        resp.setLoginTime(logBean.getLoginTime());//访问时间
        return Result.success(resp);
    }

    /**
     * 查询系统访问记录列表
     *
     * @param loginLog 请求参数
     * @return LoginLogResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<ResultPage<QueryLoginLogListRespVo>> queryLoginLogList(QueryLoginLogListReqVo loginLog) {
        LoginLogBean bean = new LoginLogBean();
        //bean.setLoginName(loginLog.getLoginName());//登录账号
        //bean.setIpaddr(loginLog.getIpaddr());//登录IP地址
        //bean.setLoginLocation(loginLog.getLoginLocation());//登录地点
        //bean.setPlatform(loginLog.getPlatform());//平台信息
        //bean.setBrowser(loginLog.getBrowser());//浏览器类型
        //bean.setVersion(loginLog.getVersion());//浏览器版本
        //bean.setOs(loginLog.getOs());//操作系统
        //bean.setArch(loginLog.getArch());//体系结构信息
        //bean.setEngine(loginLog.getEngine());//渲染引擎信息
        //bean.setEngineDetails(loginLog.getEngineDetails());//渲染引擎详细信息
        //bean.setStatus(loginLog.getStatus());//登录状态(0:失败,1:成功)
        //bean.setLoginTime(loginLog.getLoginTime());//访问时间

        PageHelper.startPage(loginLog.getPageNo(), loginLog.getPageSize());
        List<LoginLogBean> query = loginLogDao.queryLoginLogList(bean);
        PageInfo<LoginLogBean> pageInfo = new PageInfo<>(query);

        List<LoginLogBean> infoList = pageInfo.getList();
        List<QueryLoginLogListRespVo> list = new ArrayList<>();

        for (LoginLogBean logBean : infoList) {
            QueryLoginLogListRespVo resp = new QueryLoginLogListRespVo();
            resp.setId(logBean.getId());//访问ID
            resp.setLoginName(logBean.getLoginName());//登录账号
            resp.setIpaddr(logBean.getIpaddr());//登录IP地址
            resp.setLoginLocation(logBean.getLoginLocation());//登录地点
            resp.setPlatform(logBean.getPlatform());//平台信息
            resp.setBrowser(logBean.getBrowser());//浏览器类型
            resp.setVersion(logBean.getVersion());//浏览器版本
            resp.setOs(logBean.getOs());//操作系统
            resp.setArch(logBean.getArch());//体系结构信息
            resp.setEngine(logBean.getEngine());//渲染引擎信息
            resp.setEngineDetails(logBean.getEngineDetails());//渲染引擎详细信息
            resp.setExtra(logBean.getExtra());//其他信息（可选）
            resp.setStatus(logBean.getStatus());//登录状态(0:失败,1:成功)
            resp.setMsg(logBean.getMsg());//提示消息
            resp.setLoginTime(logBean.getLoginTime());//访问时间
            list.add(resp);
        }

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));

    }
}