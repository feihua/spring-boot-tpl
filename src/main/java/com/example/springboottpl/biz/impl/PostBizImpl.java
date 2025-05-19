package com.example.tpl.system.biz.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.PostBiz;
import com.example.tpl.system.dao.PostDao;
import com.example.tpl.system.entity.PostBean;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddPostReqVo;
import com.example.tpl.system.vo.req.DeletePostReqVo;
import com.example.tpl.system.vo.req.QueryPostDetailReqVo;
import com.example.tpl.system.vo.req.QueryPostListReqVo;
import com.example.tpl.system.vo.req.UpdatePostReqVo;
import com.example.tpl.system.vo.req.UpdatePostStatusReqVo;
import com.example.tpl.system.vo.resp.QueryPostDetailRespVo;
import com.example.tpl.system.vo.resp.QueryPostListRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:35
 */
@Service
public class PostBizImpl implements PostBiz {

    @Autowired
    private PostDao postDao;

    /**
     * 添加岗位信息
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> addPost(AddPostReqVo post) {

        PostBean res = postDao.queryPostByCode(post.getPostCode());
        if (res != null) {
            return Result.error("新增岗位失败,岗位编码已存在");
        }

        PostBean postBean = postDao.queryPostByName(post.getPostName());
        if (postBean != null) {
            return Result.error("新增岗位失败,岗位名称已存在");
        }

        PostBean bean = new PostBean();
        bean.setPostCode(post.getPostCode()); //岗位编码
        bean.setPostName(post.getPostName()); //岗位名称
        bean.setSort(post.getSort()); //显示顺序
        bean.setStatus(post.getStatus()); //岗位状态（0：停用，1:正常）
        bean.setRemark(post.getRemark()); //备注

        int i = postDao.addPost(bean);
        return Result.success(i);
    }

    /**
     * 删除岗位信息
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> deletePost(DeletePostReqVo post) {
        List<Long> ids = post.getIds();
        for (Long id : ids) {
            PostBean postBean = postDao.queryPostById(id);
            if (postBean == null) {
                return Result.error("删除岗位信息失败,岗位信息不存在");
            }

            int count = postDao.countUserPostById(id);
            if (count > 0) {
                return Result.error("删除岗位信息失败,已分配,不能删除");
            }
        }

        int i = postDao.deletePost(ids);
        return Result.success(i);
    }

    /**
     * 更新岗位信息
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> updatePost(UpdatePostReqVo post) {
        PostBean res = postDao.queryPostById(post.getId());
        if (res == null) {
            return Result.error("更新岗位失败,岗位不存在");
        }
        PostBean code = postDao.queryPostByCode(post.getPostCode());
        if (code != null && !Objects.equals(code.getId(), post.getId())) {
            return Result.error("更新岗位失败,岗位编码已存在");
        }

        PostBean postBean = postDao.queryPostByName(post.getPostName());
        if (postBean != null && !Objects.equals(postBean.getId(), post.getId())) {
            return Result.error("更新岗位失败,岗位名称已存在");
        }

        PostBean bean = new PostBean();
        bean.setId(post.getId());//岗位id
        bean.setPostCode(post.getPostCode());//岗位编码
        bean.setPostName(post.getPostName());//岗位名称
        bean.setSort(post.getSort());//显示顺序
        bean.setStatus(post.getStatus());//岗位状态（0：停用，1:正常）
        bean.setRemark(post.getRemark());//备注

        int i = postDao.updatePost(bean);
        return Result.success(i);
    }

    /**
     * 更新岗位信息状态
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> updatePostStatus(UpdatePostStatusReqVo post) {

        int i = postDao.updatePostStatus(post);
        return Result.success(i);
    }

    /**
     * 查询岗位信息详情
     *
     * @param post 请求参数
     * @return PostResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<QueryPostDetailRespVo> queryPostDetail(QueryPostDetailReqVo post) {
        PostBean bean = new PostBean();
        bean.setId(post.getId());//岗位id

        PostBean postBean = postDao.queryPostDetail(bean);
        if (postBean == null) {
            return Result.error("查询岗位信息详情失败,岗位信息不存在");
        }

        QueryPostDetailRespVo resp = new QueryPostDetailRespVo();
        resp.setId(postBean.getId());//岗位id
        resp.setPostCode(postBean.getPostCode());//岗位编码
        resp.setPostName(postBean.getPostName());//岗位名称
        resp.setSort(postBean.getSort());//显示顺序
        resp.setStatus(postBean.getStatus());//岗位状态（0：停用，1:正常）
        resp.setRemark(postBean.getRemark());//备注
        resp.setCreateTime(postBean.getCreateTime());//创建时间
        resp.setUpdateTime(postBean.getUpdateTime());//更新时间

        return Result.success(resp);
    }

    /**
     * 查询岗位信息列表
     *
     * @param post 请求参数
     * @return PostResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<ResultPage<QueryPostListRespVo>> queryPostList(QueryPostListReqVo post) {
        PostBean bean = new PostBean();
        bean.setPostCode(post.getPostCode());//岗位编码
        bean.setPostName(post.getPostName());//岗位名称
        bean.setStatus(post.getStatus());//岗位状态（0：停用，1:正常）

        PageHelper.startPage(post.getPageNo(), post.getPageSize());
        List<PostBean> query = postDao.queryPostList(bean);
        PageInfo<PostBean> pageInfo = new PageInfo<>(query);

        List<QueryPostListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryPostListRespVo resp = new QueryPostListRespVo();
            resp.setId(x.getId());//岗位id
            resp.setPostCode(x.getPostCode());//岗位编码
            resp.setPostName(x.getPostName());//岗位名称
            resp.setSort(x.getSort());//显示顺序
            resp.setStatus(x.getStatus());//岗位状态（0：停用，1:正常）
            resp.setRemark(x.getRemark());//备注
            resp.setCreateTime(x.getCreateTime());//创建时间
            resp.setUpdateTime(x.getUpdateTime());//更新时间
            return resp;
        }).collect(Collectors.toList());

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));

    }
}