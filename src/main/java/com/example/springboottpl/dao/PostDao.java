package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.tpl.system.entity.PostBean;
import com.example.tpl.system.vo.req.UpdatePostStatusReqVo;

/**
 * 描述：岗位信息
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface PostDao {

    /**
     * 添加岗位信息
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addPost(PostBean post);

    /**
     * 删除岗位信息
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deletePost(List<Long> ids);

    /**
     * 更新岗位信息
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updatePost(PostBean post);

    /**
     * 更新岗位信息状态
     *
     * @param post 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updatePostStatus(UpdatePostStatusReqVo post);

    /**
     * 查询岗位信息详情
     *
     * @param post 请求参数
     * @return Post
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    PostBean queryPostDetail(PostBean post);

    /**
     * 根据id查询岗位信息
     *
     * @param id 请求参数
     * @return Post
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    PostBean queryPostById(@Param("id") long id);

    /**
     * 根据postCode查询岗位信息
     *
     * @param postCode 请求参数
     * @return Post
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    PostBean queryPostByCode(@Param("postCode") String postCode);


    /**
     * 根据postName查询岗位信息
     *
     * @param postName 请求参数
     * @return Post
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    PostBean queryPostByName(@Param("postName") String postName);

    /**
     * 查询岗位信息列表
     *
     * @param post 请求参数
     * @return List<Post>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<PostBean> queryPostList(PostBean post);

    /**
     * 通过岗位id查询岗位使用数量
     *
     * @param id 请求参数
     * @return List<Post>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int countUserPostById(@Param("id") long id);
}
