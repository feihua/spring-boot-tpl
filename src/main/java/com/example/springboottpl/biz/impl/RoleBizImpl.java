package com.example.springboottpl.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.RoleBiz;
import com.example.springboottpl.dao.MenuDao;
import com.example.springboottpl.dao.RoleDao;
import com.example.springboottpl.dao.RoleDeptDao;
import com.example.springboottpl.dao.RoleMenuDao;
import com.example.springboottpl.dao.UserDao;
import com.example.springboottpl.dao.UserRoleDao;
import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.entity.RoleBean;
import com.example.springboottpl.entity.RoleMenuBean;
import com.example.springboottpl.entity.UserBean;
import com.example.springboottpl.entity.UserRoleBean;
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
import com.example.springboottpl.vo.resp.QueryRoleMenuData;
import com.example.springboottpl.vo.resp.QueryRoleMenuResp;
import com.example.springboottpl.vo.resp.QueryUserListRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2025-01-14 10:40:16
 */
@Service
public class RoleBizImpl implements RoleBiz {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private RoleDeptDao roleDeptDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    /**
     * 添加角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> addRole(AddRoleReqVo role) {
        String roleName = role.getRoleName();
        String roleKey = role.getRoleKey();

        RoleBean res = roleDao.queryRoleByName(roleName);
        if (res != null) {
            return Result.error("添加角色信息失败,角色名称已存在");
        }

        RoleBean res1 = roleDao.queryRoleByKey(roleKey);
        if (res1 != null) {
            return Result.error("添加角色信息失败,角色权限已存在");
        }

        RoleBean bean = new RoleBean();
        bean.setRoleName(roleName); //名称
        bean.setRoleKey(roleKey); //角色权限字符串
        bean.setDataScope(role.getDataScope()); //数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
        bean.setStatus(role.getStatus()); //状态(1:正常，0:禁用)
        bean.setRemark(role.getRemark()); //备注
        bean.setDelFlag(1); //删除标志（0代表删除 1代表存在）

        int i = roleDao.addRole(bean);
        return Result.success(i);
    }

    /**
     * 删除角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> deleteRole(DeleteRoleReqVo role) {
        List<Long> ids = role.getIds();
        if (ids.contains(1L)) {
            return Result.error("删除角色失败,不允许操作超级管理员角色");
        }

        for (Long id : ids) {
            RoleBean roleBean = roleDao.queryRoleById(id);
            if (roleBean == null) {
                return Result.error("删除角色失败,角色不存在");
            }

            Integer res = userRoleDao.countUserRoleByRoleId(id);
            if (res > 0) {
                return Result.error("删除角色失败,已分配,不能删除");
            }
        }

        roleMenuDao.deleteRoleMenu(ids);

        roleDeptDao.deleteRoleDept(ids);

        int i = roleDao.deleteRole(ids);

        return Result.success(i);
    }

    /**
     * 更新角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> updateRole(UpdateRoleReqVo role) {
        Long id = role.getId();
        String roleName = role.getRoleName();
        String roleKey = role.getRoleKey();

        if (id == 1) {
            return Result.error("更新角色信息失败,不允许操作超级管理员角色");
        }

        RoleBean res = roleDao.queryRoleById(id);
        if (res == null) {
            return Result.error("更新角色信息失败,角色信息不存在");
        }

        RoleBean res1 = roleDao.queryRoleByName(roleName);
        if (res1 != null && !res1.getId().equals(id)) {
            return Result.error("更新角色信息失败,角色名称已存在");
        }

        RoleBean res2 = roleDao.queryRoleByKey(roleKey);
        if (res2 != null && !res2.getId().equals(id)) {
            return Result.error("更新角色信息失败,角色权限已存在");
        }

        RoleBean bean = new RoleBean();
        bean.setId(id);//主键
        bean.setRoleName(role.getRoleName());//名称
        bean.setRoleKey(role.getRoleKey());//角色权限字符串
        bean.setDataScope(role.getDataScope());//数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
        bean.setStatus(role.getStatus());//状态(1:正常，0:禁用)
        bean.setRemark(role.getRemark());//备注
        bean.setDelFlag(res.getDelFlag());//删除标志（0代表删除 1代表存在）

        int i = roleDao.updateRole(bean);
        return Result.success(i);
    }

    /**
     * 更新角色信息状态
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> updateRoleStatus(UpdateRoleStatusReqVo role) {
        if (role.getIds().contains(1)) {
            return Result.error("更新角色信息失败,不允许操作超级管理员角色");
        }

        int i = roleDao.updateRoleStatus(role);
        return Result.success(i);
    }

    /**
     * 查询角色信息详情
     *
     * @param role 请求参数
     * @return RoleResp
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<QueryRoleDetailRespVo> queryRoleDetail(QueryRoleDetailReqVo role) {
        RoleBean bean = new RoleBean();
        bean.setId(role.getId());//主键
        //bean.setRoleName(role.getRoleName());//名称
        //bean.setRoleKey(role.getRoleKey());//角色权限字符串
        //bean.setDataScope(role.getDataScope());//数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
        //bean.setStatus(role.getStatus());//状态(1:正常，0:禁用)
        //bean.setDelFlag(role.getDelFlag());//删除标志（0代表删除 1代表存在）

        RoleBean roleBean = roleDao.queryRoleDetail(bean);
        if (roleBean == null) {
            return Result.error("查询角色信息详情失败,角色信息不存在");
        }

        QueryRoleDetailRespVo resp = new QueryRoleDetailRespVo();
        resp.setId(roleBean.getId());//主键
        resp.setRoleName(roleBean.getRoleName());//名称
        resp.setRoleKey(roleBean.getRoleKey());//角色权限字符串
        resp.setDataScope(roleBean.getDataScope());//数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
        resp.setStatus(roleBean.getStatus());//状态(1:正常，0:禁用)
        resp.setRemark(roleBean.getRemark());//备注
        resp.setDelFlag(roleBean.getDelFlag());//删除标志（0代表删除 1代表存在）
        resp.setCreateTime(roleBean.getCreateTime());//创建时间
        resp.setUpdateTime(roleBean.getUpdateTime());//修改时间

        return Result.success(resp);
    }

    /**
     * 查询角色信息列表
     *
     * @param role 请求参数
     * @return RoleResp
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<ResultPage<QueryRoleListRespVo>> queryRoleList(QueryRoleListReqVo role) {
        RoleBean bean = new RoleBean();
        bean.setRoleName(role.getRoleName());//名称
        bean.setRoleKey(role.getRoleKey());//角色权限字符串
        //        bean.setDataScope(role.getDataScope());//数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
        bean.setStatus(role.getStatus());//状态(1:正常，0:禁用)

        PageHelper.startPage(role.getPageNo(), role.getPageSize());
        List<RoleBean> query = roleDao.queryRoleList(bean);
        PageInfo<RoleBean> pageInfo = new PageInfo<>(query);

        List<QueryRoleListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryRoleListRespVo resp = new QueryRoleListRespVo();
            resp.setId(x.getId());//主键
            resp.setRoleName(x.getRoleName());//名称
            resp.setRoleKey(x.getRoleKey());//角色权限字符串
            resp.setDataScope(x.getDataScope());//数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
            resp.setStatus(x.getStatus());//状态(1:正常，0:禁用)
            resp.setRemark(x.getRemark());//备注
            resp.setDelFlag(x.getDelFlag());//删除标志（0代表删除 1代表存在）
            resp.setCreateTime(x.getCreateTime());//创建时间
            resp.setUpdateTime(x.getUpdateTime());//修改时间
            return resp;
        }).collect(Collectors.toList());

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));

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
        Long roleId = roleMenuReq.getRoleId();//角色id

        List<Long> menuIds = new ArrayList<>();
        List<QueryRoleMenuData> menuList = new ArrayList<>();

        List<MenuBean> list = menuDao.queryMenuList(null);

        for (MenuBean menu : list) {
            Long id = menu.getId();
            menuIds.add(id);
            QueryRoleMenuData menuData = new QueryRoleMenuData();
            menuData.setId(id);
            menuData.setKey(id + "");
            menuData.setParentId(menu.getParentId());
            menuData.setTitle(menu.getMenuName());
            menuData.setLabel(menu.getMenuName());
            menuData.setPenultimate(menu.getParentId() == 2);

            menuList.add(menuData);
        }

        if (!roleId.equals(1L)) {
            menuIds.clear();
            menuIds = roleMenuDao.queryMenuByRoleId(roleId);
        }

        return Result.success(new QueryRoleMenuResp(menuIds, menuList));
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
        List<Long> menuIds = roleMenuReq.getMenuIds();
        Long roleId = roleMenuReq.getRoleId();

        if (roleId.equals(1L)) {
            return Result.error("更新角色关联的菜单失败,不允许操作超级管理员角色");
        }

        roleMenuDao.deleteRoleMenu(List.of(roleId));
        menuIds.forEach(menuId -> roleMenuDao.addRoleMenu(new RoleMenuBean(roleId, menuId)));

        return Result.success();
    }

    /**
     * 查询已分配用户角色列表
     *
     * @param req 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<ResultPage<QueryUserListRespVo>> queryAllocatedList(AllocatedListReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        List<UserBean> query = userDao.queryAllocatedList(req.getRoleId(), req.getMobile(), req.getUserName());
        PageInfo<UserBean> pageInfo = new PageInfo<>(query);

        List<QueryUserListRespVo> list = pageInfo.getList()
                .stream()
                .map(x -> {
                    QueryUserListRespVo resp = new QueryUserListRespVo();
                    resp.setId(x.getId());//主键
                    resp.setMobile(x.getMobile());//手机号码
                    resp.setUserName(x.getUserName());//用户账号
                    resp.setNickName(x.getNickName());//用户昵称
                    resp.setUserType(x.getUserType());//用户类型（00系统用户）
                    resp.setAvatar(x.getAvatar());//头像路径
                    resp.setEmail(x.getEmail());//用户邮箱
                    resp.setPassword(x.getPassword());//密码
                    resp.setStatus(x.getStatus());//状态(1:正常，0:禁用)
                    resp.setDeptId(x.getDeptId());//部门ID
                    resp.setLoginIp(x.getLoginIp());//最后登录IP
                    resp.setLoginDate(x.getLoginDate());//最后登录时间
                    resp.setLoginBrowser(x.getLoginBrowser());//浏览器类型
                    resp.setLoginOs(x.getLoginOs());//操作系统
                    resp.setPwdUpdateDate(x.getPwdUpdateDate());//密码最后更新时间
                    resp.setRemark(x.getRemark());//备注
                    resp.setDelFlag(x.getDelFlag());//删除标志（0代表删除 1代表存在）
                    resp.setCreateTime(x.getCreateTime());//创建时间
                    resp.setUpdateTime(x.getUpdateTime());//修改时间
                    return resp;
                })
                .collect(Collectors.toList());

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));
    }

    /**
     * 查询未分配用户角色列表
     *
     * @param req 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<ResultPage<QueryUserListRespVo>> queryUnallocatedList(UnallocatedListReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        List<UserBean> query = userDao.queryUnallocatedList(req.getRoleId(), req.getMobile(), req.getUserName());
        PageInfo<UserBean> pageInfo = new PageInfo<>(query);

        List<QueryUserListRespVo> list = pageInfo.getList()
                .stream()
                .map(x -> {
                    QueryUserListRespVo resp = new QueryUserListRespVo();
                    resp.setId(x.getId());//主键
                    resp.setMobile(x.getMobile());//手机号码
                    resp.setUserName(x.getUserName());//用户账号
                    resp.setNickName(x.getNickName());//用户昵称
                    resp.setUserType(x.getUserType());//用户类型（00系统用户）
                    resp.setAvatar(x.getAvatar());//头像路径
                    resp.setEmail(x.getEmail());//用户邮箱
                    resp.setPassword(x.getPassword());//密码
                    resp.setStatus(x.getStatus());//状态(1:正常，0:禁用)
                    resp.setDeptId(x.getDeptId());//部门ID
                    resp.setLoginIp(x.getLoginIp());//最后登录IP
                    resp.setLoginDate(x.getLoginDate());//最后登录时间
                    resp.setLoginBrowser(x.getLoginBrowser());//浏览器类型
                    resp.setLoginOs(x.getLoginOs());//操作系统
                    resp.setPwdUpdateDate(x.getPwdUpdateDate());//密码最后更新时间
                    resp.setRemark(x.getRemark());//备注
                    resp.setDelFlag(x.getDelFlag());//删除标志（0代表删除 1代表存在）
                    resp.setCreateTime(x.getCreateTime());//创建时间
                    resp.setUpdateTime(x.getUpdateTime());//修改时间
                    return resp;
                })
                .collect(Collectors.toList());

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));
    }

    /**
     * 取消授权用户
     *
     * @param authUserReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> cancelAuthUser(CancelAuthUserReq authUserReq) {
        Long roleId = authUserReq.getRoleId();////用户id
        Long userId = authUserReq.getUserId();//角色id

        if (roleId.equals(1L)) {
            return Result.error("取消授权用户失败,不允许操作超级管理员角色");
        }

        int i = userRoleDao.deleteUseRoleByRoleIdUserId(roleId, userId);
        return Result.success(i);
    }

    /**
     * 批量取消授权用户
     *
     * @param userAllReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> batchCancelAuthUser(CancelAuthUserAllReq userAllReq) {
        List<Long> userIds = userAllReq.getUserIds();//用户ids
        Long roleId = userAllReq.getRoleId();//角色id

        userIds.forEach(userId -> userRoleDao.deleteUseRoleByRoleIdUserId(roleId, userId));

        return Result.success();
    }

    /**
     * 批量选择用户授权
     *
     * @param userAllReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @Override
    public Result<Integer> batchAuthUser(SelectAuthUserAllReq userAllReq) {
        List<Long> userIds = userAllReq.getUserIds();//用户ids
        Long roleId = userAllReq.getRoleId();//角色id

        userIds.forEach(userId -> userRoleDao.addUserRole(new UserRoleBean(userId, roleId)));

        return Result.success();
    }
}