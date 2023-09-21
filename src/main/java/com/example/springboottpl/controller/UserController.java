package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.service.UserService;
import com.example.springboottpl.util.Result;
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
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 添加用户信息
	 *
	 * @param record 请求参数
	 * @return Result<Integer>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("添加用户信息")
	@PostMapping("/saveUser")
	public Result<Integer> saveUser(@RequestBody @Valid UserAddReqVo record) {
		return Result.success(userService.saveUser(record));
	}

	/**
	 * 删除用户信息
	 *
	 * @param record 请求参数
	 * @return Result<Integer>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("删除用户信息")
	@PostMapping("/deleteUser")
	public Result<Integer> deleteUser(@RequestBody @Valid UserDeleteReqVo record) {
		return Result.success(userService.deleteUser(record));
	}

	/**
	 * 更新用户信息
	 *
	 * @param record 请求参数
	 * @return Result<Integer>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("更新用户信息")
	@PostMapping("/updateUser")
	public Result<Integer> updateUser(@RequestBody @Valid UserUpdateReqVo record) {
		return Result.success(userService.updateUser(record));
	}

	/**
	 * 查询用户信息
	 *
	 * @param record 请求参数
	 * @return UserResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("查询用户信息")
	@PostMapping("/queryUser")
	public UserRespVo query(@RequestBody @Valid UserReqVo record) {
		return userService.queryUser(record);
	}

	/**
	 * 查询用户信息列表
	 *
	 * @param record 请求参数
	 * @return UserResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("查询用户信息列表")
	@PostMapping("/queryUserList")
	public Result<ResultPage<UserRespVo>> queryUserList(@RequestBody @Valid UserListReqVo record) {
		return Result.success(userService.queryUserList(record));
	}

	/**
	 * 用户登录
	 *
	 * @param record 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("添加用户信息")
	@PostMapping("/login")
	public Result<UserLoginRespVo> login(@RequestBody @Valid UserLoginReqVo record) {
		return Result.success(userService.login(record));
	}

	/**
	 * 查询用户菜单
	 *
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("查询用户菜单")
	@GetMapping("/queryUserMenu")
	public Result<UserMenuRespVo> queryUserMenu() {
		return Result.success(userService.queryUserMenu());
	}

	/**
	 * 查询用户角色
	 *
	 * @param userId 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("查询用户角色")
	@GetMapping("/queryUserRole")
	public Result<UserRoleRespVo> queryUserRole(@RequestParam(value = "userId") Integer userId) {
		return Result.success(userService.queryUserRole(userId));
	}

	/**
	 * 更新用户角色
	 *
	 * @param record 请求参数
	 * @return Result<UserLoginRespVo>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@ApiOperation("更新用户角色")
	@PostMapping("/updateUserRole")
	public Result<Integer> updateUserRole(@RequestBody @Valid UserRoleUpdateReqVo record) {
		return Result.success(userService.updateUserRole(record));
	}
}
