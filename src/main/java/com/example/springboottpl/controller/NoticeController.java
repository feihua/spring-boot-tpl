package com.example.springboottpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.NoticeService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddNoticeReqVo;
import com.example.springboottpl.vo.req.DeleteNoticeReqVo;
import com.example.springboottpl.vo.req.QueryNoticeDetailReqVo;
import com.example.springboottpl.vo.req.QueryNoticeListReqVo;
import com.example.springboottpl.vo.req.UpdateNoticeReqVo;
import com.example.springboottpl.vo.req.UpdateNoticeStatusReqVo;
import com.example.springboottpl.vo.resp.QueryNoticeDetailRespVo;
import com.example.springboottpl.vo.resp.QueryNoticeListRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "8.通知公告")
@RestController
@RequestMapping("/notice")
public class NoticeController {

   @Autowired
   private NoticeService noticeService;

   /**
    * 添加通知公告
    *
    * @param notice 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 1)
   @Operation(summary = "1.1 添加通知公告")
   @PostMapping("/addNotice")
   @OperateLog(description = "【通知公告】添加通知公告")
   public Result<Integer> addNotice(@RequestBody @Valid AddNoticeReqVo notice){
        return noticeService.addNotice(notice);
   }

   /**
    * 删除通知公告
    *
    * @param notice 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 2)
   @Operation(summary = "1.2 删除通知公告")
   @PostMapping("/deleteNotice")
   @OperateLog(description = "【通知公告】删除通知公告")
   public Result<Integer> deleteNotice(@RequestBody @Valid DeleteNoticeReqVo notice){
        return noticeService.deleteNotice(notice);
   }

   /**
    * 更新通知公告
    *
    * @param notice 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 3)
   @Operation(summary = "1.3 更新通知公告")
   @PostMapping("/updateNotice")
   @OperateLog(description = "【通知公告】更新通知公告")
   public Result<Integer> updateNotice(@RequestBody @Valid UpdateNoticeReqVo notice){
        return noticeService.updateNotice(notice);
   }

   /**
   * 更新通知公告状态
   *
   * @param notice 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 4)
   @Operation(summary = "1.4 更新通知公告状态")
   @PostMapping("/updateNoticeStatus")
   @OperateLog(description = "【通知公告】更新通知公告状态")
  public Result<Integer> updateNoticeStatus(@RequestBody @Valid UpdateNoticeStatusReqVo notice){
       return noticeService.updateNoticeStatus(notice);
  }

   /**
    * 查询通知公告详情
    *
    * @param notice 请求参数
    * @return NoticeResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 5)
   @Operation(summary = "1.5 查询通知公告详情")
   @PostMapping("/queryNoticeDetail")
   @OperateLog(description = "【通知公告】查询通知公告详情")
   public Result<QueryNoticeDetailRespVo> queryNoticeDetail(@RequestBody @Valid QueryNoticeDetailReqVo notice){
       return noticeService.queryNoticeDetail(notice);
   }

   /**
    * 查询通知公告列表
    *
    * @param notice 请求参数
    * @return NoticeResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 6)
   @Operation(summary = "1.6 查询通知公告列表")
   @PostMapping("/queryNoticeList")
   @OperateLog(description = "【通知公告】查询通知公告列表")
   public Result<ResultPage<QueryNoticeListRespVo>> queryNoticeList(@RequestBody @Valid QueryNoticeListReqVo notice){
        return noticeService.queryNoticeList(notice);
   }

}
