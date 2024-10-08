package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.PostBean;
import com.example.springboottpl.vo.req.*;

import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.dao.PostDao;
import com.example.springboottpl.biz.PostBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
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
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int addPost(AddPostReqVo post){
        PostBean bean = new PostBean();
        bean.setTenantId(post.getTenantId());
        bean.setDeptId(post.getDeptId());
        bean.setPostCode(post.getPostCode());
        bean.setPostCategory(post.getPostCategory());
        bean.setPostName(post.getPostName());
        bean.setPostSort(post.getPostSort());
        bean.setStatus(post.getStatus());
        bean.setRemark(post.getRemark());

        return postDao.addPost(bean);
   }

   /**
    * 删除岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int deletePost(DeletePostReqVo post){
		return postDao.deletePost(post.getIds());
   }

   /**
    * 更新岗位信息
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int updatePost(UpdatePostReqVo post){
        PostBean bean = new PostBean();
        bean.setPostId(post.getPostId());
        bean.setTenantId(post.getTenantId());
        bean.setDeptId(post.getDeptId());
        bean.setPostCode(post.getPostCode());
        bean.setPostCategory(post.getPostCategory());
        bean.setPostName(post.getPostName());
        bean.setPostSort(post.getPostSort());
        bean.setStatus(post.getStatus());
        bean.setRemark(post.getRemark());
        return postDao.updatePost(bean);
   }

   /**
    * 更新岗位信息状态
    *
    * @param post 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int updatePostStatus(UpdatePostStatusReqVo post){
        PostBean bean = new PostBean();
        //bean.setPostId(post.getPostId());
        //bean.setTenantId(post.getTenantId());
        //bean.setDeptId(post.getDeptId());
        //bean.setPostCode(post.getPostCode());
        //bean.setPostCategory(post.getPostCategory());
        //bean.setPostName(post.getPostName());
        //bean.setPostSort(post.getPostSort());
        //bean.setStatus(post.getStatus());

        return postDao.updatePostStatus(bean);
   }

   /**
    * 查询岗位信息详情
    *
    * @param post 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryPostDetailRespVo queryPostDetail(QueryPostDetailReqVo post){
        PostBean bean = new PostBean();
        bean.setPostId(post.getPostId());
        //bean.setTenantId(post.getTenantId());
        //bean.setDeptId(post.getDeptId());
        //bean.setPostCode(post.getPostCode());
        //bean.setPostCategory(post.getPostCategory());
        //bean.setPostName(post.getPostName());
        //bean.setPostSort(post.getPostSort());
        //bean.setStatus(post.getStatus());

        PostBean query = postDao.queryPostDetail(bean);

        return QueryPostDetailRespVo.builder().build();
   }

   /**
    * 查询岗位信息列表
    *
    * @param post 请求参数
    * @return PostResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryPostListRespVo queryPostList(QueryPostListReqVo post){
        PostBean bean = new PostBean();
        //bean.setTenantId(post.getTenantId());
        //bean.setDeptId(post.getDeptId());
        //bean.setPostCode(post.getPostCode());
        //bean.setPostCategory(post.getPostCategory());
        //bean.setPostName(post.getPostName());
        //bean.setPostSort(post.getPostSort());
        //bean.setStatus(post.getStatus());

        PageHelper.startPage(post.getPageNum(), post.getPageSize());
	    List<PostBean> query = postDao.queryPostList(bean);
        PageInfo<PostBean> pageInfo = new PageInfo<>(query);

	    List<QueryPostListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryPostListRespVo resp = new QueryPostListRespVo();
            resp.setPostId(x.getPostId());
            resp.setTenantId(x.getTenantId());
            resp.setDeptId(x.getDeptId());
            resp.setPostCode(x.getPostCode());
            resp.setPostCategory(x.getPostCategory());
            resp.setPostName(x.getPostName());
            resp.setPostSort(x.getPostSort());
            resp.setStatus(x.getStatus());
            resp.setRemark(x.getRemark());
            resp.setCreateDept(x.getCreateDept());
            resp.setCreateBy(x.getCreateBy());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateBy(x.getUpdateBy());
            resp.setUpdateTime(x.getUpdateTime());
		   return resp;
	    }).collect(Collectors.toList());

        //return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
        return null;

   }
}