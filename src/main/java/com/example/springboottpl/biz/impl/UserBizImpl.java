package com.example.springboottpl.biz.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import com.example.springboottpl.biz.UserBiz;
import com.example.springboottpl.dao.DeptDao;
import com.example.springboottpl.dao.LoginLogDao;
import com.example.springboottpl.dao.MenuDao;
import com.example.springboottpl.dao.RoleDao;
import com.example.springboottpl.dao.UserDao;
import com.example.springboottpl.dao.UserPostDao;
import com.example.springboottpl.dao.UserRoleDao;
import com.example.springboottpl.entity.DeptBean;
import com.example.springboottpl.entity.LoginLogBean;
import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.entity.RoleBean;
import com.example.springboottpl.entity.UserBean;
import com.example.springboottpl.entity.UserPostBean;
import com.example.springboottpl.entity.UserRoleBean;
import com.example.springboottpl.util.JsonUtil;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.util.TplConstant;
import com.example.springboottpl.vo.req.AddUserReqVo;
import com.example.springboottpl.vo.req.DeleteUserReqVo;
import com.example.springboottpl.vo.req.QueryUserDetailReqVo;
import com.example.springboottpl.vo.req.QueryUserListReqVo;
import com.example.springboottpl.vo.req.UpdateUserReqVo;
import com.example.springboottpl.vo.req.UpdateUserRoleReqVo;
import com.example.springboottpl.vo.req.UpdateUserStatusReqVo;
import com.example.springboottpl.vo.req.UserLoginReqVo;
import com.example.springboottpl.vo.resp.QueryDeptDetailRespVo;
import com.example.springboottpl.vo.resp.QueryRoleDetailRespVo;
import com.example.springboottpl.vo.resp.QueryUserDetailRespVo;
import com.example.springboottpl.vo.resp.QueryUserListRespVo;
import com.example.springboottpl.vo.resp.QueryUserMenuListData;
import com.example.springboottpl.vo.resp.UserMenuRespVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025-01-14 10:40:17
 */
@Slf4j
@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserPostDao userPostDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private LoginLogDao loginLogDao;

    @Autowired(required = false)
    private HttpServletRequest request;

    /**
     * 添加用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:17
     */
    @Override
    public Result<Integer> addUser(AddUserReqVo user) {
        String name = user.getUserName();
        String mobile = user.getMobile();
        String email = user.getEmail();

        UserBean res = userDao.queryUserByName(name);
        if (res != null) {
            return Result.error("添加用户信息失败,用户名称已存在");
        }

        UserBean res1 = userDao.queryUserByMobile(mobile);
        if (res1 != null) {
            return Result.error("添加用户信息失败,手机号已存在");
        }

        UserBean res2 = userDao.queryUserByEmail(email);
        if (res2 != null) {
            return Result.error("添加用户信息失败,邮箱已存在");
        }

        String avatar = " https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png";

        UserBean bean = new UserBean();
        bean.setMobile(mobile); //手机号码
        bean.setUserName(name); //用户账号
        bean.setNickName(user.getNickName()); //用户昵称
        bean.setUserType("01"); //用户类型（00系统用户）
        bean.setAvatar(avatar); //头像路径
        bean.setEmail(email); //用户邮箱
        bean.setPassword(user.getPassword()); //密码
        bean.setStatus(user.getStatus()); //状态(1:正常，0:禁用)
        bean.setDeptId(user.getDeptId()); //部门ID
        bean.setRemark(user.getRemark()); //备注

        int i = userDao.addUser(bean);

        userRoleDao.deleteUserRole(List.of(bean.getId()));

        userPostDao.deleteUserPost(List.of(bean.getId()));

        user.getPostIds().forEach(postId -> userPostDao.addUserPost(new UserPostBean(bean.getId(), postId)));


        return Result.success(i);
    }

    /**
     * 删除用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:17
     */
    @Override
    public Result<Integer> deleteUser(DeleteUserReqVo user) {
        String userId = request.getHeader("userId");
        List<Long> ids = user.getIds();

        if (ids.contains(Long.parseLong(userId))) {
            return Result.error("删除用户信息失败,当前用户不能删除");
        }

        if (ids.contains(1L)) {
            return Result.error("删除用户信息失败,不允许操作超级管理员用户");
        }

        userRoleDao.deleteUserRole(ids);

        userPostDao.deleteUserPost(ids);

        int i = userDao.deleteUser(ids);

        return Result.success(i);
    }

    /**
     * 更新用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:17
     */
    @Override
    public Result<Integer> updateUser(UpdateUserReqVo user) {
        Long id = user.getId();
        String name = user.getUserName();
        String mobile = user.getMobile();
        String email = user.getEmail();

        if (id.equals(1L)) {
            return Result.error("更新用户信息失败,不允许操作超级管理员用户");
        }
        UserBean res = userDao.queryUserById(id);
        if (res == null) {
            return Result.error("更新用户信息失败,用户信息不存在");
        }

        UserBean res1 = userDao.queryUserByName(name);
        if (res1 != null && !res1.getId().equals(id)) {
            return Result.error("更新用户信息失败,用户名称已存在");
        }

        UserBean res2 = userDao.queryUserByMobile(mobile);
        if (res2 != null && !res2.getId().equals(id)) {
            return Result.error("更新用户信息失败,手机号已存在");
        }

        UserBean res3 = userDao.queryUserByEmail(email);
        if (res3 != null && !res3.getId().equals(id)) {
            return Result.error("更新用户信息失败,邮箱已存在");
        }

        UserBean bean = new UserBean();
        bean.setId(id);//主键
        bean.setMobile(mobile);//手机号码
        bean.setUserName(name);//用户账号
        bean.setNickName(user.getNickName());//用户昵称
        bean.setAvatar(user.getAvatar());//头像路径
        bean.setEmail(email);//用户邮箱
        bean.setStatus(user.getStatus());//状态(1:正常，0:禁用)
        bean.setDeptId(user.getDeptId());//部门ID
        bean.setRemark(user.getRemark());//备注

        int i = userDao.updateUser(bean);

        userPostDao.deleteUserPost(List.of(id));
        user.getPostIds().forEach(postId -> userPostDao.addUserPost(new UserPostBean(bean.getId(), postId)));

        return Result.success(i);
    }

    /**
     * 更新用户信息状态
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:17
     */
    @Override
    public Result<Integer> updateUserStatus(UpdateUserStatusReqVo user) {
        List<Long> ids = user.getIds();

        if (ids.contains(1L)) {
            return Result.error("删除用户信息失败,不允许操作超级管理员用户");
        }

        int i = userDao.updateUserStatus(user);
        return Result.success(i);
    }

    /**
     * 查询用户信息详情
     *
     * @param user 请求参数
     * @return UserResp
     * @author 刘飞华
     * @date: 2025-01-14 10:40:17
     */
    @Override
    public Result<QueryUserDetailRespVo> queryUserDetail(QueryUserDetailReqVo user) {

        UserBean bean = new UserBean();
        bean.setId(user.getId());//主键

        UserBean userBean = userDao.queryUserDetail(bean);
        if (userBean == null) {
            return Result.error("查询用户信息详情,用户信息不存在");
        }

        //获取部门信息
        DeptBean deptBean = deptDao.queryDeptDetail(DeptBean.builder().id(userBean.getDeptId()).build());
        if (deptBean == null) {
            return Result.error("查询部门详情失败,部门不存在");
        }

        QueryDeptDetailRespVo deptInfo = new QueryDeptDetailRespVo();
        deptInfo.setId(deptBean.getId());//部门id
        deptInfo.setParentId(deptBean.getParentId());//父部门id
        deptInfo.setAncestors(deptBean.getAncestors());//祖级列表
        deptInfo.setDeptName(deptBean.getDeptName());//部门名称
        deptInfo.setSort(deptBean.getSort());//显示顺序
        deptInfo.setLeader(deptBean.getLeader());//负责人
        deptInfo.setPhone(deptBean.getPhone());//联系电话
        deptInfo.setEmail(deptBean.getEmail());//邮箱
        deptInfo.setStatus(deptBean.getStatus());//部门状态（0：停用，1:正常）
        deptInfo.setDelFlag(deptBean.getDelFlag());//删除标志（0代表删除 1代表存在）
        deptInfo.setCreateTime(deptBean.getCreateTime());//创建时间
        deptInfo.setUpdateTime(deptBean.getUpdateTime());//修改时间

        //获取岗位ids
        UserPostBean userPost = UserPostBean.builder().userId(userBean.getId()).build();
        List<Long> postIds = userPostDao.queryUserPostList(userPost).stream().map(UserPostBean::getPostId).toList();

        QueryUserDetailRespVo resp = new QueryUserDetailRespVo();
        resp.setId(userBean.getId());//主键
        resp.setMobile(userBean.getMobile());//手机号码
        resp.setUserName(userBean.getUserName());//用户账号
        resp.setNickName(userBean.getNickName());//用户昵称
        resp.setUserType(userBean.getUserType());//用户类型（00系统用户）
        resp.setAvatar(userBean.getAvatar());//头像路径
        resp.setEmail(userBean.getEmail());//用户邮箱
        resp.setPassword(userBean.getPassword());//密码
        resp.setStatus(userBean.getStatus());//状态(1:正常，0:禁用)
        resp.setDeptId(userBean.getDeptId());//部门ID
        resp.setLoginIp(userBean.getLoginIp());//最后登录IP
        resp.setLoginDate(userBean.getLoginDate());//最后登录时间
        resp.setLoginBrowser(userBean.getLoginBrowser());//浏览器类型
        resp.setLoginOs(userBean.getLoginOs());//操作系统
        resp.setPwdUpdateDate(userBean.getPwdUpdateDate());//密码最后更新时间
        resp.setRemark(userBean.getRemark());//备注
        resp.setDelFlag(userBean.getDelFlag());//删除标志（0代表删除 1代表存在）
        resp.setCreateTime(userBean.getCreateTime());//创建时间
        resp.setUpdateTime(userBean.getUpdateTime());//修改时间
        resp.setDeptInfo(deptInfo);
        resp.setPostIds(postIds);

        return Result.success(resp);
    }

    /**
     * 查询用户信息列表
     *
     * @param user 请求参数
     * @return UserResp
     * @author 刘飞华
     * @date: 2025-01-14 10:40:17
     */
    @Override
    public Result<ResultPage<QueryUserListRespVo>> queryUserList(QueryUserListReqVo user) {
        UserBean bean = new UserBean();
        bean.setMobile(user.getMobile());//手机号码
        bean.setUserName(user.getUserName());//用户账号
        bean.setNickName(user.getNickName());//用户昵称
        bean.setUserType(user.getUserType());//用户类型（00系统用户）
        bean.setEmail(user.getEmail());//用户邮箱
        bean.setStatus(user.getStatus());//状态(1:正常，0:禁用)
        bean.setDeptId(user.getDeptId());//部门ID

        PageHelper.startPage(user.getPageNo(), user.getPageSize());
        List<UserBean> query = userDao.queryUserList(bean);
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
     * 用户登录
     *
     * @param record 请求参数
     * @return Result<String>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<String> login(UserLoginReqVo record) {

        UserBean user = userDao.queryUserByMobile(record.getMobile());
        if (user == null) {
            saveLoginLog(record.getMobile(), 0, "登录失败,用户不存在");
            return Result.error("登录失败,用户不存在");
        }

        if (!record.getPassword().equals(user.getPassword())) {
            saveLoginLog(user.getUserName(), 0, "登录失败,密码不正确");
            return Result.error("登录失败,密码不正确");
        }

        MenuBean bean = new MenuBean();
        bean.setStatus(1);
        bean.setVisible(1);
        List<MenuBean> list = user.getId() == 1 ? menuDao.queryMenuList(bean) : userDao.queryUserMenus(user.getId());

        List<String> apiUrls = list.stream().map(MenuBean::getApiUrl).filter(StringUtils::isNotBlank).toList();

        if (apiUrls.isEmpty()) {
            saveLoginLog(user.getUserName(), 0, "登录失败,用户没有分配角色或者菜单");
            return Result.error("登录失败,用户没有分配角色或者菜单");
        }

        String token = createToken(user, apiUrls);

        saveLoginLog(user.getUserName(), 1, "登录成功");


        return Result.success(token);
    }

    /**
     * 记录登录日志
     *
     * @param name 用户名
     * @author 刘飞华
     * @date: 2025/1/17 9:48
     */
    private void saveLoginLog(String name, Integer status, String msg) {
        String userAgentHeader = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentHeader);
        log.info("user agent param: {}", JsonUtil.toJson(userAgent));
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        log.info("浏览器名: {}", browser.getName());
        log.info("浏览器类型: {}", browser.getBrowserType());
        log.info("浏览器家族: {}", browser.getGroup());
        log.info("浏览器生产厂商: {}", browser.getManufacturer());
        log.info("浏览器使用的渲染引擎: {}", browser.getRenderingEngine());
        log.info("浏览器版本: {}", userAgent.getBrowserVersion());

        log.info("操作系统名: {}", operatingSystem.getName());
        log.info("访问设备类型: {}", operatingSystem.getDeviceType());
        log.info("操作系统家族: {}", operatingSystem.getGroup());
        log.info("操作系统生产厂商: {}", operatingSystem.getManufacturer());

        LoginLogBean logBean = new LoginLogBean();
        logBean.setLoginName(name);
        logBean.setIpaddr(request.getRemoteAddr());
        logBean.setLoginLocation("todo");
        logBean.setPlatform(operatingSystem.getGroup().getName());
        logBean.setBrowser(browser.getName());
        logBean.setVersion(userAgent.getBrowserVersion().getVersion());
        logBean.setOs(operatingSystem.getName());
        logBean.setArch("todo");
        logBean.setEngine(browser.getRenderingEngine().name());
        logBean.setEngineDetails("todo");
        logBean.setExtra("todo");
        logBean.setStatus(status);
        logBean.setMsg(msg);
        logBean.setLoginTime(new Date());

        loginLogDao.addLoginLog(logBean);
    }

    /**
     * 生成token
     *
     * @param user    用户信息
     * @param apiUrls 权限
     * @return str
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    private String createToken(UserBean user, List<String> apiUrls) {
        DeptBean deptBean = deptDao.queryDeptById(user.getDeptId());
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("mobile", user.getMobile());
        claims.put("userName", user.getUserName());
        claims.put("deptId", deptBean.getId());
        claims.put("deptName", deptBean.getDeptName());
        claims.put("permissions", apiUrls);
        Date expiration = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 360 * 1000L);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, TplConstant.JWT_SECRET_KEY)
                .compact();
    }

    /**
     * 查询用户菜单
     *
     * @return Result<UserLoginRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<UserMenuRespVo> queryUserMenu() {
        String userIdStr = request.getHeader("userId");

        if (StringUtils.isBlank(userIdStr)) {
            return Result.error("查询用户菜单失败, 缺少必要参数userId");
        }

        long userId = Long.parseLong(userIdStr);//用户id

        UserBean userBean = userDao.queryUserById(userId);
        if (userBean == null) {
            return Result.error("查询用户菜单失败, 用户不存在");
        }

        MenuBean bean = new MenuBean();
        bean.setStatus(1);
        bean.setVisible(1);
        List<MenuBean> list = userId == 1 ? menuDao.queryMenuList(bean) : userDao.queryUserMenus(userId);

        List<String> btnMenu = new ArrayList<>();
        List<QueryUserMenuListData> sysMenu = new ArrayList<>();

        for (MenuBean menu : list) {
            String apiUrl = menu.getApiUrl();

            if (!menu.getMenuType().equals(3)) {
                QueryUserMenuListData res = new QueryUserMenuListData();
                res.setId(menu.getId());
                res.setName(menu.getMenuName());
                res.setMenuType(menu.getMenuType());
                res.setParentId(menu.getParentId());
                res.setPath(menu.getMenuUrl());
                res.setApiUrl(apiUrl);
                res.setIcon(menu.getMenuIcon());

                sysMenu.add(res);
            }

            if (StringUtils.isNotBlank(apiUrl)) {
                btnMenu.add(apiUrl);
            }

        }

        String avatar = "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png";
        String name = request.getHeader("userName");
        return Result.success(new UserMenuRespVo(btnMenu, sysMenu, name, avatar));
    }

    /**
     * 查询用户角色
     *
     * @param userId 请求参数
     * @return UserRoleRespVo
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<UserRoleRespVo> queryUserRole(Long userId) {

        List<Long> roleIds = new ArrayList<>();
        List<QueryRoleDetailRespVo> roleList = new ArrayList<>();

        List<RoleBean> roleBeanList = roleDao.queryRoleList(new RoleBean());

        for (RoleBean x : roleBeanList) {
            QueryRoleDetailRespVo resp = new QueryRoleDetailRespVo();
            resp.setId(x.getId());//主键
            resp.setRoleName(x.getRoleName());//名称
            resp.setRoleKey(x.getRoleKey());//角色权限字符串
            resp.setDataScope(x.getDataScope());//数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
            resp.setStatus(x.getStatus());//状态(1:正常，0:禁用)
            resp.setRemark(x.getRemark());//备注
            resp.setDelFlag(x.getDelFlag());//删除标志（0代表删除 1代表存在）
            resp.setCreateTime(x.getCreateTime());//创建时间
            resp.setUpdateTime(x.getUpdateTime());//修改时间

            roleList.add(resp);
            roleIds.add(x.getId());
        }


        if (!userId.equals(1L)) {
            roleIds.clear();
            roleIds = userDao.queryRoleIdsByUserId(userId);
        }

        return Result.success(new UserRoleRespVo(roleIds, roleList));
    }

    /**
     * 更新用户角色
     *
     * @param reqVo 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @Override
    public Result<Integer> updateUserRole(UpdateUserRoleReqVo reqVo) {
        Long userId = reqVo.getUserId();
        List<Long> roleIds = reqVo.getRoleIds();

        if (userId.equals(1L)) {
            return Result.error("更新用户角色失败,不允许操作超级管理员角色");
        }

        userRoleDao.deleteUserRole(List.of(userId));
        roleIds.forEach(roleId -> userRoleDao.addUserRole(new UserRoleBean(userId, roleId)));

        return Result.success();
    }
}