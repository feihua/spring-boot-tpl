package com.example.springboottpl.biz.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import static com.example.springboottpl.enums.ExceptionEnum.USER_NAME_EXIST_ERROR;
import static com.example.springboottpl.enums.ExceptionEnum.USER_NOT_EXIST_ERROR;
import static com.example.springboottpl.enums.ExceptionEnum.USER_PASSWORD_ERROR;
import static com.example.springboottpl.enums.StatusEnum.enable;

import com.example.springboottpl.biz.LoginLogBiz;
import com.example.springboottpl.biz.MenuBiz;
import com.example.springboottpl.biz.RoleBiz;
import com.example.springboottpl.biz.UserBiz;
import com.example.springboottpl.biz.UserRoleBiz;
import com.example.springboottpl.dao.UserDao;
import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.entity.RoleBean;
import com.example.springboottpl.entity.UserBean;
import com.example.springboottpl.enums.MenuTypeEnum;
import com.example.springboottpl.exception.TplException;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.util.TplConstant;
import com.example.springboottpl.vo.req.LoginLogAddReqVo;
import com.example.springboottpl.vo.req.RoleListReqVo;
import com.example.springboottpl.vo.req.UserAddReqVo;
import com.example.springboottpl.vo.req.UserDeleteReqVo;
import com.example.springboottpl.vo.req.UserListReqVo;
import com.example.springboottpl.vo.req.UserLoginReqVo;
import com.example.springboottpl.vo.req.UserReqVo;
import com.example.springboottpl.vo.req.UserRoleAddReqVo;
import com.example.springboottpl.vo.req.UserRoleUpdateReqVo;
import com.example.springboottpl.vo.req.UserUpdateReqVo;
import com.example.springboottpl.vo.resp.MenuRespVo;
import com.example.springboottpl.vo.resp.RoleRespVo;
import com.example.springboottpl.vo.resp.UserLoginRespVo;
import com.example.springboottpl.vo.resp.UserMenuRespVo;
import com.example.springboottpl.vo.resp.UserRespVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Service
@Slf4j
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleBiz userRoleBiz;

	@Autowired
	private MenuBiz menuBiz;

	@Autowired
	private RoleBiz roleBiz;

	@Autowired
	private LoginLogBiz loginLogBiz;

	@Autowired(required = false)
	private HttpServletRequest request;

	/**
	 * 添加用户信息
	 *
	 * @param user 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public int saveUser(UserAddReqVo user) {
		UserBean bean = new UserBean();
		bean.setMobile(user.getMobile());
		if (userDao.queryUser(bean) != null) {
			throw new TplException(USER_NAME_EXIST_ERROR);
		}
		bean.setUserName(user.getUserName());
		bean.setPassword(TplConstant.INITIALIZE_PASSWORD);
		bean.setStatusId(user.getStatusId());
		bean.setSort(user.getSort());
		bean.setRemark(user.getRemark());

		return userDao.saveUser(bean);
	}

	/**
	 * 删除用户信息
	 *
	 * @param user 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public int deleteUser(UserDeleteReqVo user) {
		return userDao.deleteUser(user.getIds());
	}

	/**
	 * 更新用户信息
	 *
	 * @param user 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public int updateUser(UserUpdateReqVo user) {
		UserBean bean = new UserBean();
		bean.setId(user.getId());
		if (userDao.queryUser(bean) == null) {
			throw new TplException(USER_NOT_EXIST_ERROR);
		}
		bean.setMobile(user.getMobile());
		bean.setUserName(user.getUserName());
		//bean.setPassword(user.getPassword());
		bean.setStatusId(user.getStatusId());
		bean.setSort(user.getSort());
		bean.setRemark(user.getRemark());

		return userDao.updateUser(bean);
	}

	/**
	 * 查询用户信息
	 *
	 * @param user 请求参数
	 * @return UserResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserRespVo queryUser(UserReqVo user) {
		UserBean bean = new UserBean();
		//bean.setId(user.getId());
		//bean.setMobile(user.getMobile());
		//bean.setUserName(user.getUserName());
		//bean.setPassword(user.getPassword());
		//bean.setStatusId(user.getStatusId());
		//bean.setSort(user.getSort());
		//bean.setRemark(user.getRemark());
		//bean.setCreateTime(user.getCreateTime());
		//bean.setUpdateTime(user.getUpdateTime());

		UserBean query = userDao.queryUser(bean);

		return UserRespVo.builder().build();
	}

	/**
	 * 查询用户信息列表
	 *
	 * @param user 请求参数
	 * @return UserResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public ResultPage<UserRespVo> queryUserList(UserListReqVo user) {
		UserBean bean = new UserBean();
		bean.setMobile(user.getMobile());
		bean.setUserName(user.getUserName());
		bean.setStatusId(user.getStatusId());

		PageHelper.startPage(user.getPageNo(), user.getPageSize());
		List<UserBean> query = userDao.queryUserList(bean);
		PageInfo<UserBean> pageInfo = new PageInfo<>(query);

		List<UserRespVo> list = pageInfo.getList().stream().map(x -> {
			UserRespVo resp = new UserRespVo();
			resp.setId(x.getId());
			resp.setMobile(x.getMobile());
			resp.setUserName(x.getUserName());
			resp.setPassword(x.getPassword());
			resp.setStatusId(x.getStatusId());
			resp.setSort(x.getSort());
			resp.setRemark(x.getRemark());
			resp.setCreateTime(x.getCreateTime());
			resp.setUpdateTime(x.getUpdateTime());
			return resp;
		}).collect(Collectors.toList());

		return new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());

	}

	/**
	 * 用户登录
	 *
	 * @param record 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserLoginRespVo login(UserLoginReqVo record) {

		UserBean user = userDao.queryUser(UserBean.builder().mobile(record.getMobile()).build());

		checkUser(record, user);

		return buildLoginResp(user);
	}

	/**
	 * 校验合法性
	 *
	 * @param record 请求参数
	 * @param user 用户信息
	 * @return
	 * @author 刘飞华
	 * @date: 2023/9/20 14:33
	 */
	private void checkUser(UserLoginReqVo record, UserBean user) {
		if (user == null) {
			log.error("用户信息：{}不存在", record);
			throw new TplException(USER_NOT_EXIST_ERROR);
		}

		if (!Objects.equals(record.getPassword(), user.getPassword())) {
			log.error("密码不正确");
			throw new TplException(USER_PASSWORD_ERROR);
		}
	}

	/**
	 * 构建登录返回
	 *
	 * @param user 用户信息
	 * @return resp
	 * @author 刘飞华
	 * @date: 2023/9/20 14:32
	 */
	private UserLoginRespVo buildLoginResp(UserBean user) {
		boolean isAdmin = userRoleBiz.queryIsAdmin(user.getId(), TplConstant.ADMIN_ROLE_ID);

		List<MenuBean> menuList = isAdmin ? menuBiz.queryMenuListMenuBean() : userDao.queryUserMenus(user.getId());

		List<String> apiUrls = menuList.stream().map(MenuBean::getApiUrl).filter(Objects::nonNull)
				.filter(x -> !x.isEmpty()).collect(Collectors.toList());

		String token = createToken(user, apiUrls);

		UserLoginRespVo loginRespVo = new UserLoginRespVo();
		loginRespVo.setId(user.getId());
		loginRespVo.setMobile(user.getMobile());
		loginRespVo.setUserName(user.getUserName());
		loginRespVo.setToken(token);

		LoginLogAddReqVo logAddReqVo = new LoginLogAddReqVo();
		logAddReqVo.setUserId(user.getId());
		logAddReqVo.setUserName(user.getUserName());
		logAddReqVo.setIpAddress(request.getRemoteAddr());

		loginLogBiz.saveLoginLog(logAddReqVo);
		return loginRespVo;
	}

	/**
	 * 生成token
	 *
	 * @param user 用户信息
	 * @param apiUrls 权限
	 * @return str
	 * @author 刘飞华
	 * @date: 2023/9/20 14:36
	 */
	private String createToken(UserBean user, List<String> apiUrls) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", user.getId());
		claims.put("mobile", user.getMobile());
		claims.put("userName", user.getUserName());
		claims.put("permissions", apiUrls);
		Date expiration = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000L);
		return Jwts.builder().setClaims(claims).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, TplConstant.JWT_SECRET_KEY).compact();
	}

	/**
	 * 查询用户菜单
	 *
	 * @param userId 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserMenuRespVo queryUserMenu(Integer userId) {
		boolean isAdmin = userRoleBiz.queryIsAdmin(userId, TplConstant.ADMIN_ROLE_ID);

		List<MenuBean> menuList = isAdmin ? menuBiz.queryMenuListMenuBean() : userDao.queryUserMenus(userId);

		//过滤出可用的菜单和权限
		List<MenuBean> list = menuList.stream().filter(x -> x.getStatusId() == enable.getCode())
				.collect(Collectors.toList());

		//权限
		List<String> btnPaths = list.stream().filter(x -> x.getMenuType() == MenuTypeEnum.button.getCode())
				.map(MenuBean::getApiUrl).filter(Objects::nonNull).filter(x -> !x.isEmpty())
				.collect(Collectors.toList());

		//菜单
		List<MenuRespVo> leftMenuData = list.stream().filter(x -> x.getMenuType() != MenuTypeEnum.button.getCode())
				.map(x -> {
					MenuRespVo menuData = MenuRespVo.builder().build();
					BeanUtils.copyProperties(x, menuData);
					return menuData;
				}).collect(Collectors.toList());

		String avatar = "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png";
		String name = request.getHeader("userName");
		return UserMenuRespVo.builder().btnPaths(btnPaths).leftMenuData(leftMenuData).avatar(avatar).name(name).build();
	}

	/**
	 * 查询用户角色
	 *
	 * @param userId 请求参数
	 * @return UserRoleRespVo
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserRoleRespVo queryUserRole(Integer userId) {
		//根据userId查询用户拥有的角色
		List<RoleBean> list = userDao.queryUserRoles(userId);
		List<RoleRespVo> userRoleList = list.stream().map(this::buildRoleResp).collect(Collectors.toList());

		//获取拥有角色的ids
		List<Integer> userRoleIds = userRoleList.stream().map(RoleRespVo::getId).collect(Collectors.toList());

		//查询所有角色
		RoleListReqVo role = RoleListReqVo.builder().pageNo(1).pageSize(1000).build();
		List<RoleRespVo> allRoleList = roleBiz.queryRoleList(role).getList();

		return UserRoleRespVo.builder().roleIds(userRoleIds).allRoleList(allRoleList).userRoleList(userRoleList)
				.build();
	}

	/**
	 * 构建角色返回
	 *
	 * @param roleBean 角色
	 * @return RoleRespVo
	 * @author 刘飞华
	 * @date: 2023/9/20 16:48
	 */
	private RoleRespVo buildRoleResp(RoleBean roleBean) {
		RoleRespVo roleResp = RoleRespVo.builder().build();
		BeanUtils.copyProperties(roleBean, roleResp);
		return roleResp;
	}

	/**
	 * 更新用户角色
	 *
	 * @param record 请求参数
	 * @return Integer
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public Integer updateUserRole(UserRoleUpdateReqVo record) {
		Integer userId = record.getUserId();
		List<Integer> roleIds = record.getRoleIds();

		userRoleBiz.deleteUserRole(userId);

		for (Integer roleId : roleIds) {
			userRoleBiz.saveUserRole(UserRoleAddReqVo.builder().userId(userId).roleId(roleId).build());
		}

		return roleIds.size();
	}
}