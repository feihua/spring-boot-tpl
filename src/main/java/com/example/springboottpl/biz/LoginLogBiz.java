package com.example.springboottpl.biz;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.DeleteLoginLogReqVo;
import com.example.springboottpl.vo.req.QueryLoginLogDetailReqVo;
import com.example.springboottpl.vo.req.QueryLoginLogListReqVo;
import com.example.springboottpl.vo.resp.QueryLoginLogDetailRespVo;
import com.example.springboottpl.vo.resp.QueryLoginLogListRespVo;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface LoginLogBiz {


   /**
    * 删除系统访问记录
    *
    * @param loginLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteLoginLog(DeleteLoginLogReqVo loginLog);

   /**
    * 清空系统访问记录
    *
    * @return int
    * @author 刘飞华
    * @date: 2025/01/10 15:34:35
    */
   Result<Integer> cleanLoginLog();

   /**
    * 查询系统访问记录详情
    *
    * @param loginLog 请求参数
    * @return LoginLogResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryLoginLogDetailRespVo> queryLoginLogDetail(QueryLoginLogDetailReqVo loginLog);

   /**
    * 查询系统访问记录列表
    *
    * @param loginLog 请求参数
    * @return ResultPage<LoginLogResp>
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<ResultPage<QueryLoginLogListRespVo>> queryLoginLogList(QueryLoginLogListReqVo loginLog);

}