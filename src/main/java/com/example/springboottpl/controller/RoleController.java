package com.example.springboottpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.springboottpl.annotation.OperateLog;
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
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "2.角色信息")
@RestController
@RequestMapping("/role")
public class RoleController {

   @Autowired
   private RoleService roleService;

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 1)
   @Operation(summary = "1.1 添加角色信息")
   @PostMapping("/addRole")
   @OperateLog(description = "【角色信息】添加角色信息")
   public Result<Integer> addRole(@RequestBody @Valid AddRoleReqVo role){
        return roleService.addRole(role);
   }

   /**
    * 删除角色信息
    *
    * @param role 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 2)
   @Operation(summary = "1.2 删除角色信息")
   @PostMapping("/deleteRole")
   @OperateLog(description = "【角色信息】删除角色信息")
   public Result<Integer> deleteRole(@RequestBody @Valid DeleteRoleReqVo role){
        return roleService.deleteRole(role);
   }

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 3)
   @Operation(summary = "1.3 更新角色信息")
   @PostMapping("/updateRole")
   @OperateLog(description = "【角色信息】更新角色信息")
   public Result<Integer> updateRole(@RequestBody @Valid UpdateRoleReqVo role){
        return roleService.updateRole(role);
   }

   /**
   * 更新角色信息状态
   *
   * @param role 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 4)
   @Operation(summary = "1.4 更新角色信息状态")
   @PostMapping("/updateRoleStatus")
   @OperateLog(description = "【角色信息】更新角色信息状态")
  public Result<Integer> updateRoleStatus(@RequestBody @Valid UpdateRoleStatusReqVo role){
       return roleService.updateRoleStatus(role);
  }

   /**
    * 查询角色信息详情
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 5)
   @Operation(summary = "1.5 查询角色信息详情")
   @PostMapping("/queryRoleDetail")
   @OperateLog(description = "【角色信息】查询角色信息详情")
   public Result<QueryRoleDetailRespVo> queryRoleDetail(@RequestBody @Valid QueryRoleDetailReqVo role){
       return roleService.queryRoleDetail(role);
   }

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 6)
   @Operation(summary = "1.6 查询角色信息列表")
   @PostMapping("/queryRoleList")
   @OperateLog(description = "【角色信息】查询角色信息列表")
   public Result<ResultPage<QueryRoleListRespVo>> queryRoleList(@RequestBody @Valid QueryRoleListReqVo role){
        return roleService.queryRoleList(role);
   }

    /**
     * 查询角色关联的菜单
     *
     * @param roleMenuReq 请求参数
     * @return QueryMenuListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 7)
    @Operation(summary = "1.7 查询角色关联的菜单")
    @PostMapping("/queryRoleMenu")
    @OperateLog(description = "【角色信息】查询角色关联的菜单")
    public Result<QueryRoleMenuResp> queryRoleMenu(@RequestBody @Valid QueryRoleMenuReq roleMenuReq){
        return roleService.queryRoleMenu(roleMenuReq);
    }

    /**
     * 更新角色关联的菜单
     *
     * @param roleMenuReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 8)
    @Operation(summary = "1.8 更新角色关联的菜单")
    @PostMapping("/updateRoleMenu")
    @OperateLog(description = "【角色信息】更新角色关联的菜单")
    public Result<Integer> updateRoleMenu(@RequestBody @Valid UpdateRoleMenuReq roleMenuReq){
        return roleService.updateRoleMenu(roleMenuReq);
    }

    /**
     * 查询已分配用户角色列表
     *
     * @param allocatedListReq 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 9)
    @Operation(summary = "1.9 查询已分配用户角色列表")
    @PostMapping("/queryAllocatedList")
    @OperateLog(description = "【角色信息】查询已分配用户角色列表")
    public Result<ResultPage<QueryUserListRespVo>> queryAllocatedList(@RequestBody @Valid AllocatedListReq allocatedListReq){
        return roleService.queryAllocatedList(allocatedListReq);
    }

    /**
     * 查询未分配用户角色列表
     *
     * @param unallocatedListReq 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 10)
    @Operation(summary = "1.10 查询未分配用户角色列表")
    @PostMapping("/queryUnallocatedList")
    @OperateLog(description = "【角色信息】查询未分配用户角色列表")
    public Result<ResultPage<QueryUserListRespVo>> queryUnallocatedList(@RequestBody @Valid UnallocatedListReq unallocatedListReq){
        return roleService.queryUnallocatedList(unallocatedListReq);
    }

    /**
     * 取消授权用户
     *
     * @param cancelAuthUserReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 11)
    @Operation(summary = "1.11 取消授权用户")
    @PostMapping("/cancelAuthUser")
    @OperateLog(description = "【角色信息】取消授权用户")
    public Result<Integer> cancelAuthUser(@RequestBody @Valid CancelAuthUserReq cancelAuthUserReq){
        return roleService.cancelAuthUser(cancelAuthUserReq);
    }

    /**
     * 批量取消授权用户
     *
     * @param authUserAllReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 12)
    @Operation(summary = "1.12 批量取消授权用户")
    @PostMapping("/batchCancelAuthUser")
    @OperateLog(description = "【角色信息】批量取消授权用户")
    public Result<Integer> batchCancelAuthUser(@RequestBody @Valid CancelAuthUserAllReq authUserAllReq){
        return roleService.batchCancelAuthUser(authUserAllReq);
    }

    /**
     * 批量选择用户授权
     *
     * @param authUserAllReq 请求参数
     * @return Integer
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 13)
    @Operation(summary = "1.13 批量选择用户授权")
    @PostMapping("/batchAuthUser")
    @OperateLog(description = "【角色信息】批量选择用户授权")
    public Result<Integer> batchAuthUser(@RequestBody @Valid SelectAuthUserAllReq authUserAllReq){
        return roleService.batchAuthUser(authUserAllReq);
    }
}
