package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.TenantPackageBiz;
import com.example.springboottpl.service.TenantPackageService;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Service
public class TenantPackageServiceImpl implements TenantPackageService {

   @Autowired
   private TenantPackageBiz tenantPackageBiz;

   /**
    * 添加租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int addTenantPackage(AddTenantPackageReqVo tenantPackage){

        return tenantPackageBiz.addTenantPackage(tenantPackage);
   }

   /**
    * 删除租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int deleteTenantPackage(DeleteTenantPackageReqVo tenantPackage){
		return tenantPackageBiz.deleteTenantPackage(tenantPackage);
   }

   /**
    * 更新租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int updateTenantPackage(UpdateTenantPackageReqVo tenantPackage){

        return tenantPackageBiz.updateTenantPackage(tenantPackage);
   }

   /**
   * 更新租户套餐状态
   *
   * @param tenantPackage 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2024-10-08 14:26:31
   */
  @Override
  public int updateTenantPackageStatus(UpdateTenantPackageStatusReqVo tenantPackage){

       return tenantPackageBiz.updateTenantPackageStatus(tenantPackage);
  }

   /**
    * 查询租户套餐详情
    *
    * @param tenantPackage 请求参数
    * @return TenantPackageResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryTenantPackageDetailRespVo queryTenantPackageDetail(QueryTenantPackageDetailReqVo tenantPackage){

       return tenantPackageBiz.queryTenantPackageDetail(tenantPackage);
   }

   /**
    * 查询租户套餐列表
    *
    * @param tenantPackage 请求参数
    * @return TenantPackageResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryTenantPackageListRespVo queryTenantPackageList(QueryTenantPackageListReqVo tenantPackage){

        return tenantPackageBiz.queryTenantPackageList(tenantPackage);
   }

}