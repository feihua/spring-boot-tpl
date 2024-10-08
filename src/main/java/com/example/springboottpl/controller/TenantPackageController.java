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
import com.example.springboottpl.service.TenantPackageService;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Api(tags = "租户套餐")
@RestController
@RequestMapping("/tenantPackage")
public class TenantPackageController {

   @Autowired
   private TenantPackageService tenantPackageService;

   /**
    * 添加租户套餐
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("添加租户套餐")
   @PostMapping("/addTenantPackage")
   @OperateLog(description = "【租户套餐】添加租户套餐")
   public Integer addTenantPackage(@RequestBody @Valid AddTenantPackageReqVo record){
        return tenantPackageService.addTenantPackage(record);
   }

   /**
    * 删除租户套餐
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("删除租户套餐")
   @PostMapping("/deleteTenantPackage")
   @OperateLog(description = "【租户套餐】删除租户套餐")
   public Integer deleteTenantPackage(@RequestBody @Valid DeleteTenantPackageReqVo record){
        return tenantPackageService.deleteTenantPackage(record);
   }

   /**
    * 更新租户套餐
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("更新租户套餐")
   @PostMapping("/updateTenantPackage")
   @OperateLog(description = "【租户套餐】更新租户套餐")
   public Integer updateTenantPackage(@RequestBody @Valid UpdateTenantPackageReqVo record){
        return tenantPackageService.updateTenantPackage(record);
   }

   /**
   * 更新租户套餐状态
   *
   * @param record 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2024-10-08 14:26:31
   */
  @ApiOperation("更新租户套餐状态")
  @PostMapping("/updateTenantPackageStatus")
  @OperateLog(description = "【租户套餐】更新租户套餐状态")
  public Integer updateTenantPackageStatus(@RequestBody @Valid UpdateTenantPackageStatusReqVo record){
       return tenantPackageService.updateTenantPackageStatus(record);
  }

   /**
    * 查询租户套餐详情
    *
    * @param record 请求参数
    * @return TenantPackageResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("查询租户套餐详情")
   @PostMapping("/queryTenantPackageDetail")
   @OperateLog(description = "【租户套餐】查询租户套餐详情")
   public QueryTenantPackageDetailRespVo queryTenantPackageDetail(@RequestBody @Valid QueryTenantPackageDetailReqVo record){
       return tenantPackageService.queryTenantPackageDetail(record);
   }

   /**
    * 查询租户套餐列表
    *
    * @param record 请求参数
    * @return TenantPackageResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @ApiOperation("查询租户套餐列表")
   @PostMapping("/queryTenantPackageList")
   @OperateLog(description = "【租户套餐】查询租户套餐列表")
   public QueryTenantPackageListRespVo queryTenantPackageList(@RequestBody @Valid QueryTenantPackageListReqVo record){
        return tenantPackageService.queryTenantPackageList(record);
   }

}
