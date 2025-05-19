package com.example.springboottpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.MenuService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.vo.req.AddMenuReqVo;
import com.example.springboottpl.vo.req.DeleteMenuReqVo;
import com.example.springboottpl.vo.req.QueryMenuDetailReqVo;
import com.example.springboottpl.vo.req.QueryMenuListReqVo;
import com.example.springboottpl.vo.req.UpdateMenuReqVo;
import com.example.springboottpl.vo.req.UpdateMenuStatusReqVo;
import com.example.springboottpl.vo.resp.QueryMenuDetailRespVo;
import com.example.springboottpl.vo.resp.QueryMenuListRespVo;
import com.example.springboottpl.vo.resp.QueryMenuSimpleListRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "3.菜单信息")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加菜单信息
     *
     * @param menu 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "1.1 添加菜单信息")
    @PostMapping("/addMenu")
    @OperateLog(description = "【菜单信息】添加菜单信息")
    public Result<Integer> addMenu(@RequestBody @Valid AddMenuReqVo menu) {
        return menuService.addMenu(menu);
    }

    /**
     * 删除菜单信息
     *
     * @param menu 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "1.2 删除菜单信息")
    @PostMapping("/deleteMenu")
    @OperateLog(description = "【菜单信息】删除菜单信息")
    public Result<Integer> deleteMenu(@RequestBody @Valid DeleteMenuReqVo menu) {
        return menuService.deleteMenu(menu);
    }

    /**
     * 更新菜单信息
     *
     * @param menu 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "1.3 更新菜单信息")
    @PostMapping("/updateMenu")
    @OperateLog(description = "【菜单信息】更新菜单信息")
    public Result<Integer> updateMenu(@RequestBody @Valid UpdateMenuReqVo menu) {
        return menuService.updateMenu(menu);
    }

    /**
     * 更新菜单信息状态
     *
     * @param menu 请求参数
     * @return Result<Integer>
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "1.4 更新菜单信息状态")
    @PostMapping("/updateMenuStatus")
    @OperateLog(description = "【菜单信息】更新菜单信息状态")
    public Result<Integer> updateMenuStatus(@RequestBody @Valid UpdateMenuStatusReqVo menu) {
        return menuService.updateMenuStatus(menu);
    }

    /**
     * 查询菜单信息详情
     *
     * @param menu 请求参数
     * @return MenuResp
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "1.5 查询菜单信息详情")
    @PostMapping("/queryMenuDetail")
    @OperateLog(description = "【菜单信息】查询菜单信息详情")
    public Result<QueryMenuDetailRespVo> queryMenuDetail(@RequestBody @Valid QueryMenuDetailReqVo menu) {
        return menuService.queryMenuDetail(menu);
    }

    /**
     * 查询菜单信息列表
     *
     * @param menu 请求参数
     * @return List
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "1.6 查询菜单信息列表")
    @PostMapping("/queryMenuList")
    @OperateLog(description = "【菜单信息】查询菜单信息列表")
    public Result<List<QueryMenuListRespVo>> queryMenuList(@RequestBody @Valid QueryMenuListReqVo menu) {
        return menuService.queryMenuList(menu);
    }

    /**查询菜单信息(排除按钮)
     *
     * @return List
     * @author 刘飞华
     * @date: 2025/1/20 9:10
     */
    @ApiOperationSupport(order = 7)
    @Operation(summary = "1.6 查询菜单信息(排除按钮)")
    @GetMapping("/queryMenuListSimple")
    @OperateLog(description = "【菜单信息】查询菜单信息(排除按钮)")
    public Result<List<QueryMenuSimpleListRespVo>> queryMenuListSimple() {
        return menuService.queryMenuListSimple();
    }

}
