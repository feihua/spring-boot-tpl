package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboottpl.entity.NoticeBean;
import com.example.springboottpl.vo.req.UpdateNoticeStatusReqVo;

/**
 * 描述：通知公告
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface NoticeDao {

    /**
     * 添加通知公告
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addNotice(NoticeBean notice);

    /**
     * 删除通知公告
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteNotice(List<Integer> ids);

    /**
     * 更新通知公告
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateNotice(NoticeBean notice);

    /**
     * 更新通知公告状态
     *
     * @param notice 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateNoticeStatus(UpdateNoticeStatusReqVo notice);

    /**
     * 查询通知公告详情
     *
     * @param notice 请求参数
     * @return Notice
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    NoticeBean queryNoticeDetail(NoticeBean notice);

    /**
     * 根据id查询通知公告
     *
     * @param id 请求参数
     * @return Notice
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    NoticeBean queryNoticeById(@Param("id") long id);


    /**
     * 根据标题查询通知公告
     *
     * @param title 请求参数
     * @return Notice
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    NoticeBean queryNoticeByTitle(@Param("title") String title);

    /**
     * 查询通知公告列表
     *
     * @param notice 请求参数
     * @return List<Notice>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<NoticeBean> queryNoticeList(NoticeBean notice);

}
