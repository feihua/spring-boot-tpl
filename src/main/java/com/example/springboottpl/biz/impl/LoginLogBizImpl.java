package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.LoginLogBiz;
import com.example.springboottpl.dao.LoginLogDao;
import com.example.springboottpl.entity.LoginLogBean;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.LoginLogAddReqVo;
import com.example.springboottpl.vo.req.LoginLogDeleteReqVo;
import com.example.springboottpl.vo.req.LoginLogListReqVo;
import com.example.springboottpl.vo.resp.LoginLogRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:59:01
 */
@Service
public class LoginLogBizImpl implements LoginLogBiz {

   @Autowired
   private LoginLogDao loginLogDao;

   /**
    * 添加登录日志
    *
    * @param loginLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   @Override
   public int saveLoginLog(LoginLogAddReqVo loginLog){
        LoginLogBean bean = new LoginLogBean();
        bean.setUserId(loginLog.getUserId());
        bean.setUserName(loginLog.getUserName());
        bean.setIpAddress(loginLog.getIpAddress());

        return loginLogDao.saveLoginLog(bean);
   }

   /**
    * 删除登录日志
    *
    * @param loginLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   @Override
   public int deleteLoginLog(LoginLogDeleteReqVo loginLog){
		return loginLogDao.deleteLoginLog(loginLog.getIds());
   }



   /**
    * 查询登录日志列表
    *
    * @param loginLog 请求参数
    * @return LoginLogResp
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   @Override
   public ResultPage<LoginLogRespVo> queryLoginLogList(LoginLogListReqVo loginLog){
        LoginLogBean bean = new LoginLogBean();
        bean.setUserId(loginLog.getUserId());
        bean.setUserName(loginLog.getUserName());
        bean.setIpAddress(loginLog.getIpAddress());

        PageHelper.startPage(loginLog.getPageNo(), loginLog.getPageSize());
	    List<LoginLogBean> query = loginLogDao.queryLoginLogList(bean);
        PageInfo<LoginLogBean> pageInfo = new PageInfo<>(query);

	    List<LoginLogRespVo> list = pageInfo.getList().stream().map(x -> {
            LoginLogRespVo resp = new LoginLogRespVo();
            resp.setId(x.getId());
            resp.setUserId(x.getUserId());
            resp.setUserName(x.getUserName());
            resp.setIpAddress(x.getIpAddress());
            resp.setCreateTime(x.getCreateTime());
		   return resp;
	    }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
}