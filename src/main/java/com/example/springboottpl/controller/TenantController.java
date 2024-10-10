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
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.service.TenantService;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Api(tags = "租户")
@RestController
@RequestMapping("/tenant")
public class TenantController {

   @Autowired
   private TenantService tenantService;

   /**
    * 添加租户
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("添加租户")
   @PostMapping("/addTenant")
   @OperateLog(description = "【租户】添加租户")
   public Integer addTenant(@RequestBody @Valid AddTenantReqVo record){
        return tenantService.addTenant(record);
   }

   /**
    * 删除租户
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("删除租户")
   @PostMapping("/deleteTenant")
   @OperateLog(description = "【租户】删除租户")
   public Integer deleteTenant(@RequestBody @Valid DeleteTenantReqVo record){
        return tenantService.deleteTenant(record);
   }

   /**
    * 更新租户
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("更新租户")
   @PostMapping("/updateTenant")
   @OperateLog(description = "【租户】更新租户")
   public Integer updateTenant(@RequestBody @Valid UpdateTenantReqVo record){
        return tenantService.updateTenant(record);
   }

   /**
   * 更新租户状态
   *
   * @param record 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2024-10-08 14:26:31
   */
  @ApiOperation("更新租户状态")
  @PostMapping("/updateTenantStatus")
  @OperateLog(description = "【租户】更新租户状态")
  public Integer updateTenantStatus(@RequestBody @Valid UpdateTenantStatusReqVo record){
       return tenantService.updateTenantStatus(record);
  }

   /**
    * 查询租户详情
    *
    * @param record 请求参数
    * @return TenantResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("查询租户详情")
   @PostMapping("/queryTenantDetail")
   @OperateLog(description = "【租户】查询租户详情")
   public QueryTenantDetailRespVo queryTenantDetail(@RequestBody @Valid QueryTenantDetailReqVo record){
       return tenantService.queryTenantDetail(record);
   }

   /**
    * 查询租户列表
    *
    * @param record 请求参数
    * @return TenantResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("查询租户列表")
   @PostMapping("/queryTenantList")
   @OperateLog(description = "【租户】查询租户列表")
   public ResultPage<QueryTenantListRespVo> queryTenantList(@RequestBody @Valid QueryTenantListReqVo record){
        return tenantService.queryTenantList(record);
   }

}
