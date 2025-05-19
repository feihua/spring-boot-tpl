package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.tpl.system.entity.UserPostBean;

/**
 * 描述：用户与岗位关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:37
 */
@Mapper
public interface UserPostDao {

    /**
     * 添加用户与岗位关联
     *
     * @param userPost 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int addUserPost(UserPostBean userPost);

    /**
     * 删除用户与岗位关联
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int deleteUserPost(List<Long> ids);

    /**
     * 更新用户与岗位关联
     *
     * @param userPost 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int updateUserPost(UserPostBean userPost);

    /**
     * 更新用户与岗位关联状态
     *
     * @param userPost 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int updateUserPostStatus(UserPostBean userPost);

    /**
     * 查询用户与岗位关联详情
     *
     * @param userPost 请求参数
     * @return UserPost
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    UserPostBean queryUserPostDetail(UserPostBean userPost);

    /**
     * 查询用户与岗位关联列表
     *
     * @param userPost 请求参数
     * @return List<UserPost>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    List<UserPostBean> queryUserPostList(UserPostBean userPost);

}
