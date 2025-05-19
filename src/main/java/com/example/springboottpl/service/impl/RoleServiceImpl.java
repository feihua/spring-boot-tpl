package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.RoleBiz;
import com.example.springboottpl.service.RoleService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddRoleReqVo;
import com.example.springboottpl.vo.req.AllocatedListReq;
import com.example.springboottpl.vo.req.CancelAuthUserAllReq;
import com.example.springboottpl.vo.req.CancelAuthUserReq;
import com.example.springboottpl.vo.req.DeleteRoleReqVo;
import com.example.springboottpl.vo.req.QueryRoleDetailReqVo;
import com.example.springboottpl.vo.req.QueryRoleListReqVo;
import com.example.springboottpl.vo.req.QueryRoleMenuReq;
import com.example.springboottpl.vo.req.SelectAuthUserAllReq;
import com.example.springboottpl.vo.req.UnallocatedListReq;
import com.example.springboottpl.vo.req.UpdateRoleMenuReq;
import com.example.springboottpl.vo.req.UpdateRoleReqVo;
import com.example.springboottpl.vo.req.UpdateRoleStatusReqVo;
import com.example.springboottpl.vo.resp.QueryRoleDetailRespVo;
import com.example.springboottpl.vo.resp.QueryRoleListRespVo;
import com.example.springboottpl.vo.resp.QueryRoleMenuResp;
import com.example.springboottpl.vo.resp.QueryUserListRespVo;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:37
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleBiz roleBiz;

    /**
     * 添加角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> addRole(AddRoleReqVo role) {

        return roleBiz.addRole(role);
    }

    /**
     * 删除角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> deleteRole(DeleteRoleReqVo role) {
        return roleBiz.deleteRole(role);
    }

    /**
     * 更新角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> updateRole(UpdateRoleReqVo role) {

        return roleBiz.updateRole(role);
    }

    /**
     * 更新角色信息状态
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> updateRoleStatus(UpdateRoleStatusReqVo role) {

        return roleBiz.updateRoleStatus(role);
    }

    /**
     * 查询角色信息详情
     *
     * @param role 请求参数
     * @return RoleResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<QueryRoleDetailRespVo> queryRoleDetail(QueryRoleDetailReqVo role) {

        return roleBiz.queryRoleDetail(role);
    }

    /**
     * 查询角色信息列表
     *
     * @param role 请求参数
     * @return RoleResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<ResultPage<QueryRoleListRespVo>> queryRoleList(QueryRoleListReqVo role) {

        return roleBiz.queryRoleList(role);
    }

    /**
     * 查询角色关联的菜单
     *
     * @param roleMenuReq 请求参数
     * @return QueryMenuListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<QueryRoleMenuResp> queryRoleMenu(QueryRoleMenuReq roleMenuReq) {
        return roleBiz.queryRoleMenu(roleMenuReq);
    }

    /**
     * 更新角色关联的菜单
     *
     * @param roleMenuReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> updateRoleMenu(UpdateRoleMenuReq roleMenuReq) {
        return roleBiz.updateRoleMenu(roleMenuReq);
    }

    /**
     * 查询已分配用户角色列表
     *
     * @param allocatedListReq 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<ResultPage<QueryUserListRespVo>> queryAllocatedList(AllocatedListReq allocatedListReq) {
        return roleBiz.queryAllocatedList(allocatedListReq);
    }

    /**
     * 查询未分配用户角色列表
     *
     * @param unallocatedListReq 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<ResultPage<QueryUserListRespVo>> queryUnallocatedList(UnallocatedListReq unallocatedListReq) {
        return roleBiz.queryUnallocatedList(unallocatedListReq);
    }

    /**
     * 取消授权用户
     *
     * @param cancelAuthUserReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> cancelAuthUser(CancelAuthUserReq cancelAuthUserReq) {
        return roleBiz.cancelAuthUser(cancelAuthUserReq);
    }

    /**
     * 批量取消授权用户
     *
     * @param authUserAllReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> batchCancelAuthUser(CancelAuthUserAllReq authUserAllReq) {
        return roleBiz.batchCancelAuthUser(authUserAllReq);
    }

    /**
     * 批量选择用户授权
     *
     * @param authUserAllReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> batchAuthUser(SelectAuthUserAllReq authUserAllReq) {
        return roleBiz.batchAuthUser(authUserAllReq);
    }
}