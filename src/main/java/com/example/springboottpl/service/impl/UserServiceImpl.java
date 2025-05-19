package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.UserBiz;
import com.example.springboottpl.service.UserService;
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
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBiz userBiz;

    /**
     * 添加用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> addUser(AddUserReqVo user) {

        return userBiz.addUser(user);
    }

    /**
     * 删除用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> deleteUser(DeleteUserReqVo user) {
        return userBiz.deleteUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> updateUser(UpdateUserReqVo user) {

        return userBiz.updateUser(user);
    }

    /**
     * 更新用户信息状态
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> updateUserStatus(UpdateUserStatusReqVo user) {

        return userBiz.updateUserStatus(user);
    }

    /**
     * 查询用户信息详情
     *
     * @param user 请求参数
     * @return UserResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<QueryUserDetailRespVo> queryUserDetail(QueryUserDetailReqVo user) {

        return userBiz.queryUserDetail(user);
    }

    /**
     * 查询用户信息列表
     *
     * @param user 请求参数
     * @return UserResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<ResultPage<QueryUserListRespVo>> queryUserList(QueryUserListReqVo user) {

        return userBiz.queryUserList(user);
    }

    /**
     * 用户登录
     *
     * @param record 请求参数
     * @return Result<String>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<String> login(UserLoginReqVo record) {
        return userBiz.login(record);
    }

    /**
     * 查询用户菜单
     *
     * @return Result<UserMenuRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<UserMenuRespVo> queryUserMenu() {
        return userBiz.queryUserMenu();
    }

    /**
     * 查询用户角色
     *
     * @param userId 请求参数
     * @return Result<UserRoleRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<UserRoleRespVo> queryUserRole(Long userId) {
        return userBiz.queryUserRole(userId);
    }

    /**
     * 更新用户角色
     *
     * @param roleReqVo 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> updateUserRole(UpdateUserRoleReqVo roleReqVo) {
        return userBiz.updateUserRole(roleReqVo);
    }


}