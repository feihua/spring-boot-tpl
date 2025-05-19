package com.example.springboottpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.DeptService;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.vo.req.AddDeptReqVo;
import com.example.springboottpl.vo.req.DeleteDeptReqVo;
import com.example.springboottpl.vo.req.QueryDeptDetailReqVo;
import com.example.springboottpl.vo.req.QueryDeptListReqVo;
import com.example.springboottpl.vo.req.UpdateDeptReqVo;
import com.example.springboottpl.vo.req.UpdateDeptStatusReqVo;
import com.example.springboottpl.vo.resp.QueryDeptDetailRespVo;
import com.example.springboottpl.vo.resp.QueryDeptListRespVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:34
 */
@Tag(name = "4.部门管理")
@RestController
@RequestMapping("/dept")
public class DeptController {

   @Autowired
   private DeptService deptService;

   /**
    * 添加部门
    *
    * @param dept 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 1)
   @Operation(summary = "1.1 添加部门")
   @PostMapping("/addDept")
   @OperateLog(description = "【部门管理】添加部门")
   public Result<Integer> addDept(@RequestBody @Valid AddDeptReqVo dept){
        return deptService.addDept(dept);
   }

   /**
    * 删除部门
    *
    * @param dept 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 2)
   @Operation(summary = "1.2 删除部门")
   @PostMapping("/deleteDept")
   @OperateLog(description = "【部门管理】删除部门")
   public Result<Integer> deleteDept(@RequestBody @Valid DeleteDeptReqVo dept){
        return deptService.deleteDept(dept);
   }

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 3)
   @Operation(summary = "1.3 更新部门")
   @PostMapping("/updateDept")
   @OperateLog(description = "【部门管理】更新部门")
   public Result<Integer> updateDept(@RequestBody @Valid UpdateDeptReqVo dept){
        return deptService.updateDept(dept);
   }

   /**
   * 更新部门状态
   *
   * @param dept 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 4)
   @Operation(summary = "1.4 更新部门状态")
   @PostMapping("/updateDeptStatus")
   @OperateLog(description = "【部门管理】更新部门状态")
  public Result<Integer> updateDeptStatus(@RequestBody @Valid UpdateDeptStatusReqVo dept){
       return deptService.updateDeptStatus(dept);
  }

   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 5)
   @Operation(summary = "1.5 查询部门详情")
   @PostMapping("/queryDeptDetail")
   @OperateLog(description = "【部门管理】查询部门详情")
   public Result<QueryDeptDetailRespVo> queryDeptDetail(@RequestBody @Valid QueryDeptDetailReqVo dept){
       return deptService.queryDeptDetail(dept);
   }

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 6)
   @Operation(summary = "1.6 查询部门列表")
   @PostMapping("/queryDeptList")
   @OperateLog(description = "【部门管理】查询部门列表")
   public Result<List<QueryDeptListRespVo>> queryDeptList(@RequestBody @Valid QueryDeptListReqVo dept){
        return deptService.queryDeptList(dept);
   }

}
