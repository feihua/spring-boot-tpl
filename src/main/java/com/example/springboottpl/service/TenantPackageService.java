package com.example.springboottpl.service;

import java.util.List;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
public interface TenantPackageService {

   /**
    * 添加租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int addTenantPackage(AddTenantPackageReqVo tenantPackage);

   /**
    * 删除租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int deleteTenantPackage(DeleteTenantPackageReqVo tenantPackage);

   /**
    * 更新租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenantPackage(UpdateTenantPackageReqVo tenantPackage);

   /**
    * 更新租户套餐状态
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenantPackageStatus(UpdateTenantPackageStatusReqVo tenantPackage);


   /**
    * 查询租户套餐详情
    *
    * @param tenantPackage 请求参数
    * @return QueryTenantPackageDetailResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   QueryTenantPackageDetailRespVo queryTenantPackageDetail(QueryTenantPackageDetailReqVo tenantPackage);

   /**
    * 查询租户套餐列表
    *
    * @param tenantPackage 请求参数
    * @return QueryTenantPackageListResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   ResultPage<QueryTenantPackageListRespVo> queryTenantPackageList(QueryTenantPackageListReqVo tenantPackage);

   /**
    * 查询租户套餐下拉选列表
    *
    * @return TenantPackageResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   List<QueryTenantPackageDetailRespVo> queryAllList();
}