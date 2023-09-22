package com.example.springboottpl.biz;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.LoginLogReqVo;
import com.example.springboottpl.vo.req.LoginLogListReqVo;
import com.example.springboottpl.vo.req.LoginLogAddReqVo;
import com.example.springboottpl.vo.req.LoginLogDeleteReqVo;
import com.example.springboottpl.vo.req.LoginLogUpdateReqVo;
import com.example.springboottpl.vo.resp.LoginLogRespVo;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:59:01
 */
public interface LoginLogBiz {

   /**
    * 添加登录日志
    *
    * @param loginLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   int saveLoginLog(LoginLogAddReqVo loginLog);

   /**
    * 删除登录日志
    *
    * @param loginLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   int deleteLoginLog(LoginLogDeleteReqVo loginLog);


   /**
    * 查询登录日志列表
    *
    * @param loginLog 请求参数
    * @return ResultPage<LoginLogResp>
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   ResultPage<LoginLogRespVo> queryLoginLogList(LoginLogListReqVo loginLog);

}