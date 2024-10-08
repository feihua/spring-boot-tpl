package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.service.DeptService;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Api(tags = "部门")
@RestController
@RequestMapping("/dept")
public class DeptController {

   @Autowired
   private DeptService deptService;

   /**
    * 添加部门
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("添加部门")
   @PostMapping("/addDept")
   @OperateLog(description = "【部门】添加部门")
   public Integer addDept(@RequestBody @Valid AddDeptReqVo record){
        return deptService.addDept(record);
   }

   /**
    * 删除部门
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("删除部门")
   @PostMapping("/deleteDept")
   @OperateLog(description = "【部门】删除部门")
   public Integer deleteDept(@RequestBody @Valid DeleteDeptReqVo record){
        return deptService.deleteDept(record);
   }

   /**
    * 更新部门
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("更新部门")
   @PostMapping("/updateDept")
   @OperateLog(description = "【部门】更新部门")
   public Integer updateDept(@RequestBody @Valid UpdateDeptReqVo record){
        return deptService.updateDept(record);
   }

   /**
   * 更新部门状态
   *
   * @param record 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2024-10-08 14:26:30
   */
  @ApiOperation("更新部门状态")
  @PostMapping("/updateDeptStatus")
  @OperateLog(description = "【部门】更新部门状态")
  public Integer updateDeptStatus(@RequestBody @Valid UpdateDeptStatusReqVo record){
       return deptService.updateDeptStatus(record);
  }

   /**
    * 查询部门详情
    *
    * @param record 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("查询部门详情")
   @PostMapping("/queryDeptDetail")
   @OperateLog(description = "【部门】查询部门详情")
   public QueryDeptDetailRespVo queryDeptDetail(@RequestBody @Valid QueryDeptDetailReqVo record){
       return deptService.queryDeptDetail(record);
   }

   /**
    * 查询部门列表
    *
    * @param record 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("查询部门列表")
   @PostMapping("/queryDeptList")
   @OperateLog(description = "【部门】查询部门列表")
   public QueryDeptListRespVo queryDeptList(@RequestBody @Valid QueryDeptListReqVo record){
        return deptService.queryDeptList(record);
   }

}
