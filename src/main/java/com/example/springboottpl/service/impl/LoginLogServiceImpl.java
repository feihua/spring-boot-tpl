package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.LoginLogBiz;
import com.example.springboottpl.service.LoginLogService;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.LoginLogAddReqVo;
import com.example.springboottpl.vo.req.LoginLogDeleteReqVo;
import com.example.springboottpl.vo.req.LoginLogListReqVo;
import com.example.springboottpl.vo.resp.LoginLogRespVo;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:59:01
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

   @Autowired
   private LoginLogBiz loginLogBiz;

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

        return loginLogBiz.saveLoginLog(loginLog);
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
		return loginLogBiz.deleteLoginLog(loginLog);
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

        return loginLogBiz.queryLoginLogList(loginLog);
   }

}