package com.example.springboottpl.service;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddUserReqVo;
import com.example.springboottpl.vo.req.DeleteUserReqVo;
import com.example.springboottpl.vo.req.QueryUserDetailReqVo;
import com.example.springboottpl.vo.req.QueryUserListReqVo;
import com.example.springboottpl.vo.req.UpdateUserReqVo;
import com.example.springboottpl.vo.req.UpdateUserRoleReqVo;
import com.example.springboottpl.vo.req.UpdateUserStatusReqVo;
import com.example.springboottpl.vo.req.UserLoginReqVo;
import com.example.springboottpl.vo.resp.QueryUserDetailRespVo;
import com.example.springboottpl.vo.resp.QueryUserListRespVo;
import com.example.springboottpl.vo.resp.UserMenuRespVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:37
 */
public interface UserService {

    /**
     * 添加用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<Integer> addUser(AddUserReqVo user);

    /**
     * 删除用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<Integer> deleteUser(DeleteUserReqVo user);

    /**
     * 更新用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<Integer> updateUser(UpdateUserReqVo user);

    /**
     * 更新用户信息状态
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<Integer> updateUserStatus(UpdateUserStatusReqVo user);


    /**
     * 查询用户信息详情
     *
     * @param user 请求参数
     * @return QueryUserDetailResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<QueryUserDetailRespVo> queryUserDetail(QueryUserDetailReqVo user);

    /**
     * 查询用户信息列表
     *
     * @param user 请求参数
     * @return QueryUserListResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<ResultPage<QueryUserListRespVo>> queryUserList(QueryUserListReqVo user);

    /**
     * 用户登录
     *
     * @param record 请求参数
     * @return Result<String>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<String> login(UserLoginReqVo record);

    /**
     * 查询用户菜单
     *
     * @return Result<UserMenuRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<UserMenuRespVo> queryUserMenu();

    /**
     * 查询用户角色
     *
     * @param userId 请求参数
     * @return Result<UserRoleRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<UserRoleRespVo> queryUserRole(Long userId);

    /**
     * 更新用户角色
     *
     * @param record 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    Result<Integer> updateUserRole(UpdateUserRoleReqVo record);


}