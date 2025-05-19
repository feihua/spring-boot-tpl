package com.example.tpl.system.biz;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddNoticeReqVo;
import com.example.tpl.system.vo.req.DeleteNoticeReqVo;
import com.example.tpl.system.vo.req.QueryNoticeDetailReqVo;
import com.example.tpl.system.vo.req.QueryNoticeListReqVo;
import com.example.tpl.system.vo.req.UpdateNoticeReqVo;
import com.example.tpl.system.vo.req.UpdateNoticeStatusReqVo;
import com.example.tpl.system.vo.resp.QueryNoticeDetailRespVo;
import com.example.tpl.system.vo.resp.QueryNoticeListRespVo;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface NoticeBiz {

   /**
    * 添加通知公告
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addNotice(AddNoticeReqVo notice);

   /**
    * 删除通知公告
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteNotice(DeleteNoticeReqVo notice);

   /**
    * 更新通知公告
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateNotice(UpdateNoticeReqVo notice);

   /**
    * 更新通知公告状态
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateNoticeStatus(UpdateNoticeStatusReqVo notice);

   /**
    * 查询通知公告详情
    *
    * @param notice 请求参数
    * @return NoticeResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryNoticeDetailRespVo> queryNoticeDetail(QueryNoticeDetailReqVo notice);

   /**
    * 查询通知公告列表
    *
    * @param notice 请求参数
    * @return ResultPage<NoticeResp>
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<ResultPage<QueryNoticeListRespVo>> queryNoticeList(QueryNoticeListReqVo notice);

}