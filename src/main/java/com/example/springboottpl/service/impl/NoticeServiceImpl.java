package com.example.tpl.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.*;
import com.example.tpl.system.vo.resp.*;
import com.example.tpl.system.biz.NoticeBiz;
import com.example.tpl.system.service.NoticeService;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
@Service
public class NoticeServiceImpl implements NoticeService {

   @Autowired
   private NoticeBiz noticeBiz;

   /**
    * 添加通知公告
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> addNotice(AddNoticeReqVo notice){

        return noticeBiz.addNotice(notice);
   }

   /**
    * 删除通知公告
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> deleteNotice(DeleteNoticeReqVo notice){
		return noticeBiz.deleteNotice(notice);
   }

   /**
    * 更新通知公告
    *
    * @param notice 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> updateNotice(UpdateNoticeReqVo notice){

        return noticeBiz.updateNotice(notice);
   }

   /**
   * 更新通知公告状态
   *
   * @param notice 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2025/01/13 17:57:36
   */
  @Override
  public Result<Integer> updateNoticeStatus(UpdateNoticeStatusReqVo notice){

       return noticeBiz.updateNoticeStatus(notice);
  }

   /**
    * 查询通知公告详情
    *
    * @param notice 请求参数
    * @return NoticeResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<QueryNoticeDetailRespVo> queryNoticeDetail(QueryNoticeDetailReqVo notice){

       return noticeBiz.queryNoticeDetail(notice);
   }

   /**
    * 查询通知公告列表
    *
    * @param notice 请求参数
    * @return NoticeResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<ResultPage<QueryNoticeListRespVo>> queryNoticeList(QueryNoticeListReqVo notice){

        return noticeBiz.queryNoticeList(notice);
   }

}