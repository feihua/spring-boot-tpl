package com.example.tpl.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.LoginLogBiz;
import com.example.tpl.system.service.LoginLogService;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.DeleteLoginLogReqVo;
import com.example.tpl.system.vo.req.QueryLoginLogDetailReqVo;
import com.example.tpl.system.vo.req.QueryLoginLogListReqVo;
import com.example.tpl.system.vo.resp.QueryLoginLogDetailRespVo;
import com.example.tpl.system.vo.resp.QueryLoginLogListRespVo;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogBiz loginLogBiz;

    /**
     * 删除系统访问记录
     *
     * @param loginLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<Integer> deleteLoginLog(DeleteLoginLogReqVo loginLog) {
        return loginLogBiz.deleteLoginLog(loginLog);
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
        return loginLogBiz.cleanLoginLog();
    }

    /**
     * 查询系统访问记录详情
     *
     * @param loginLog 请求参数
     * @return LoginLogResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<QueryLoginLogDetailRespVo> queryLoginLogDetail(QueryLoginLogDetailReqVo loginLog) {

        return loginLogBiz.queryLoginLogDetail(loginLog);
    }

    /**
     * 查询系统访问记录列表
     *
     * @param loginLog 请求参数
     * @return LoginLogResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:36
     */
    @Override
    public Result<ResultPage<QueryLoginLogListRespVo>> queryLoginLogList(QueryLoginLogListReqVo loginLog) {

        return loginLogBiz.queryLoginLogList(loginLog);
    }

}