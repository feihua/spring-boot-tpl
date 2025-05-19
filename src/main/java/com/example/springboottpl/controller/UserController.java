package com.example.tpl.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.tpl.system.annotation.OperateLog;
import com.example.tpl.system.service.UserService;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddUserReqVo;
import com.example.tpl.system.vo.req.DeleteUserReqVo;
import com.example.tpl.system.vo.req.QueryUserDetailReqVo;
import com.example.tpl.system.vo.req.QueryUserListReqVo;
import com.example.tpl.system.vo.req.QueryUserRoleListReqVo;
import com.example.tpl.system.vo.req.UpdateUserReqVo;
import com.example.tpl.system.vo.req.UpdateUserRoleReqVo;
import com.example.tpl.system.vo.req.UpdateUserStatusReqVo;
import com.example.tpl.system.vo.req.UserLoginReqVo;
import com.example.tpl.system.vo.resp.QueryUserDetailRespVo;
import com.example.tpl.system.vo.resp.QueryUserListRespVo;
import com.example.tpl.system.vo.resp.UserMenuRespVo;
import com.example.tpl.system.vo.resp.UserRoleRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025/01/10 16:00:47
 */
@ApiSupport(order = 100)
@Tag(name = "1.用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     *
     * @param user 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "1.1 添加用户信息")
    @PostMapping("/addUser")
    @OperateLog(description = "【用户信息】添加用户信息")
    public Result<Integer> addUser(@RequestBody @Valid AddUserReqVo user) {
        return userService.addUser(user);
    }

    /**
     * 删除用户信息
     *
     * @param user 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "1.2 删除用户信息")
    @PostMapping("/deleteUser")
    @OperateLog(description = "【用户信息】删除用户信息")
    public Result<Integer> deleteUser(@RequestBody @Valid DeleteUserReqVo user) {
        return userService.deleteUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "1.3 更新用户信息")
    @PostMapping("/updateUser")
    @OperateLog(description = "【用户信息】更新用户信息")
    public Result<Integer> updateUser(@RequestBody @Valid UpdateUserReqVo user) {
        return userService.updateUser(user);
    }

    /**
     * 更新用户信息状态
     *
     * @param user 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "1.4 更新用户信息状态")
    @PostMapping("/updateUserStatus")
    @OperateLog(description = "【用户信息】更新用户信息状态")
    public Result<Integer> updateUserStatus(@RequestBody @Valid UpdateUserStatusReqVo user) {
        return userService.updateUserStatus(user);
    }

    /**
     * 查询用户信息
     *
     * @param user 请求参数
     * @return UserResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "1.5 查询用户信息")
    @PostMapping("/queryUserDetail")
    @OperateLog(description = "【用户信息】查询用户信息")
    public Result<QueryUserDetailRespVo> queryUserDetail(@RequestBody @Valid QueryUserDetailReqVo user) {
        return userService.queryUserDetail(user);
    }

    /**
     * 查询用户信息列表
     *
     * @param user 请求参数
     * @return UserResp
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "1.6 查询用户信息列表")
    @PostMapping("/queryUserList")
    @OperateLog(description = "【用户信息】查询用户信息列表")
    public Result<ResultPage<QueryUserListRespVo>> queryUserList(@RequestBody @Valid QueryUserListReqVo user) {
        return userService.queryUserList(user);
    }

    /**
     * 用户登录
     *
     * @param record 请求参数
     * @return Result<String>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 7)
    @Operation(summary = "1.7 用户登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody @Valid UserLoginReqVo record) {
        return userService.login(record);
    }

    /**
     * 查询用户菜单
     *
     * @return Result<UserMenuRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 8)
    @Operation(summary = "1.8 查询用户菜单")
    @GetMapping("/queryUserMenu")
    @OperateLog(description = "【用户管理】查询用户菜单")
    public Result<UserMenuRespVo> queryUserMenu() {
        return userService.queryUserMenu();
    }

    /**
     * 查询用户角色
     *
     * @param roleReqVo 请求参数
     * @return Result<UserRoleRespVo>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 9)
    @Operation(summary = "1.9 查询用户角色")
    @PostMapping("/queryUserRole")
    @OperateLog(description = "【用户管理】查询用户角色")
    public Result<UserRoleRespVo> queryUserRole(@RequestBody @Valid QueryUserRoleListReqVo roleReqVo) {
        return userService.queryUserRole(roleReqVo.getUserId());
    }

    /**
     * 更新用户角色
     *
     * @param roleReqVo 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/13 17:57:37
     */
    @ApiOperationSupport(order = 10)
    @Operation(summary = "1.10 更新用户角色")
    @PostMapping("/updateUserRole")
    @OperateLog(description = "【用户管理】更新用户角色")
    public Result<Integer> updateUserRole(@RequestBody @Valid UpdateUserRoleReqVo roleReqVo) {
        return userService.updateUserRole(roleReqVo);
    }
}
