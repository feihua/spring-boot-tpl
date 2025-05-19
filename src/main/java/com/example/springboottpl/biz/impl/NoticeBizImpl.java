package com.example.tpl.system.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.NoticeBiz;
import com.example.tpl.system.dao.NoticeDao;
import com.example.tpl.system.entity.NoticeBean;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:35
 */
@Service
public class NoticeBizImpl implements NoticeBiz {

    @Autowired
    private NoticeDao noticeDao;

    /**
     * 添加通知公告
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> addNotice(AddNoticeReqVo notice) {

        NoticeBean noticeBean = noticeDao.queryNoticeByTitle(notice.getNoticeTitle());
        if (noticeBean != null) {
            return Result.error("添加通知公告失败,标题已存在");
        }

        NoticeBean bean = new NoticeBean();
        bean.setNoticeTitle(notice.getNoticeTitle()); //公告标题
        bean.setNoticeType(notice.getNoticeType()); //公告类型（1:通知,2:公告）
        bean.setNoticeContent(notice.getNoticeContent()); //公告内容
        bean.setStatus(notice.getStatus()); //公告状态（0:关闭,1:正常 ）
        bean.setRemark(notice.getRemark()); //备注

        int i = noticeDao.addNotice(bean);

        return Result.success(i);
    }

    /**
     * 删除通知公告
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> deleteNotice(DeleteNoticeReqVo notice) {
        int i = noticeDao.deleteNotice(notice.getIds());
        return Result.success(i);
    }

    /**
     * 更新通知公告
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> updateNotice(UpdateNoticeReqVo notice) {

        NoticeBean noticeBean = noticeDao.queryNoticeById(notice.getId());
        if (noticeBean == null) {
            return Result.error("更新通知公告失败,通知公告不存在");
        }
        NoticeBean res = noticeDao.queryNoticeByTitle(notice.getNoticeTitle());
        if (res != null && !Objects.equals(res.getId(), notice.getId())) {
            return Result.error("更新通知公告失败,标题已存在");
        }

        NoticeBean bean = new NoticeBean();
        bean.setId(notice.getId());//公告ID
        bean.setNoticeTitle(notice.getNoticeTitle());//公告标题
        bean.setNoticeType(notice.getNoticeType());//公告类型（1:通知,2:公告）
        bean.setNoticeContent(notice.getNoticeContent());//公告内容
        bean.setStatus(notice.getStatus());//公告状态（0:关闭,1:正常 ）
        bean.setRemark(notice.getRemark());//备注

        int i = noticeDao.updateNotice(bean);

        return Result.success(i);
    }

    /**
     * 更新通知公告状态
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> updateNoticeStatus(UpdateNoticeStatusReqVo notice) {

        int i = noticeDao.updateNoticeStatus(notice);

        return Result.success(i);
    }

    /**
     * 查询通知公告详情
     *
     * @param notice 请求参数
     * @return NoticeResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<QueryNoticeDetailRespVo> queryNoticeDetail(QueryNoticeDetailReqVo notice) {
        NoticeBean bean = new NoticeBean();
        bean.setId(notice.getId());

        NoticeBean item = noticeDao.queryNoticeDetail(bean);

        if (item == null) {
            return Result.error("查询通知公告详情失败,通知公告不存在");
        }

        QueryNoticeDetailRespVo resp = new QueryNoticeDetailRespVo();
        resp.setId(item.getId());//公告ID
        resp.setNoticeTitle(item.getNoticeTitle());//公告标题
        resp.setNoticeType(item.getNoticeType());//公告类型（1:通知,2:公告）
        resp.setNoticeContent(item.getNoticeContent());//公告内容
        resp.setStatus(item.getStatus());//公告状态（0:关闭,1:正常 ）
        resp.setRemark(item.getRemark());//备注
        resp.setCreateTime(item.getCreateTime());//创建时间
        resp.setUpdateTime(item.getUpdateTime());//修改时间

        return Result.success(resp);
    }

    /**
     * 查询通知公告列表
     *
     * @param notice 请求参数
     * @return NoticeResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<ResultPage<QueryNoticeListRespVo>> queryNoticeList(QueryNoticeListReqVo notice) {
        NoticeBean bean = new NoticeBean();
        bean.setNoticeTitle(notice.getNoticeTitle());
        bean.setNoticeType(notice.getNoticeType());
        bean.setStatus(notice.getStatus());

        PageHelper.startPage(notice.getPageNo(), notice.getPageSize());
        List<NoticeBean> query = noticeDao.queryNoticeList(bean);
        PageInfo<NoticeBean> info = new PageInfo<>(query);

        List<NoticeBean> infoList = info.getList();

        List<QueryNoticeListRespVo> list = new ArrayList<>();
        for (NoticeBean x : infoList) {
            QueryNoticeListRespVo resp = new QueryNoticeListRespVo();
            resp.setId(x.getId());//公告ID
            resp.setNoticeTitle(x.getNoticeTitle());//公告标题
            resp.setNoticeType(x.getNoticeType());//公告类型（1:通知,2:公告）
            resp.setNoticeContent(x.getNoticeContent());//公告内容
            resp.setStatus(x.getStatus());//公告状态（0:关闭,1:正常 ）
            resp.setRemark(x.getRemark());//备注
            resp.setCreateTime(x.getCreateTime());//创建时间
            resp.setUpdateTime(x.getUpdateTime());//修改时间

            list.add(resp);
        }

        return Result.success(new ResultPage<>(list, info.getPageNum(), info.getPageSize(), info.getTotal()));

    }
}