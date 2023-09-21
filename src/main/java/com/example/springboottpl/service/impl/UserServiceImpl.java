package com.example.springboottpl.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import static com.example.springboottpl.enums.ExceptionEnum.USER_ID_IS_NULL_ERROR;

import com.example.springboottpl.biz.UserBiz;
import com.example.springboottpl.exception.TplException;
import com.example.springboottpl.service.UserService;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserAddReqVo;
import com.example.springboottpl.vo.req.UserDeleteReqVo;
import com.example.springboottpl.vo.req.UserListReqVo;
import com.example.springboottpl.vo.req.UserLoginReqVo;
import com.example.springboottpl.vo.req.UserReqVo;
import com.example.springboottpl.vo.req.UserRoleUpdateReqVo;
import com.example.springboottpl.vo.req.UserUpdateReqVo;
import com.example.springboottpl.vo.resp.UserLoginRespVo;
import com.example.springboottpl.vo.resp.UserMenuRespVo;
import com.example.springboottpl.vo.resp.UserRespVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBiz userBiz;

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

		return userBiz.saveUser(user);
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
		return userBiz.deleteUser(user);
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

		return userBiz.updateUser(user);
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

		return userBiz.queryUser(user);
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

		return userBiz.queryUserList(user);
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
		return userBiz.login(record);
	}

	/**
	 * 查询用户角色
	 *
	 * @param userId 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserRoleRespVo queryUserRole(Integer userId) {
		return userBiz.queryUserRole(userId);
	}

	/**
	 * 更新用户角色
	 *
	 * @param record 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public Integer updateUserRole(UserRoleUpdateReqVo record) {
		return userBiz.updateUserRole(record);
	}

	/**
	 * 查询用户菜单
	 *
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserMenuRespVo queryUserMenu() {
		String userId = request.getHeader("userId");
		if (null == userId || "".equals(userId)) {
			log.error(USER_ID_IS_NULL_ERROR.getMsg());
			throw new TplException(USER_ID_IS_NULL_ERROR);
		}
		return userBiz.queryUserMenu(Integer.parseInt(userId));
	}
}