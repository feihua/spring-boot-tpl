package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.TenantBiz;
import com.example.springboottpl.service.TenantService;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Service
public class TenantServiceImpl implements TenantService {

   @Autowired
   private TenantBiz tenantBiz;

   /**
    * 添加租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int addTenant(AddTenantReqVo tenant){

        return tenantBiz.addTenant(tenant);
   }

   /**
    * 删除租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int deleteTenant(DeleteTenantReqVo tenant){
		return tenantBiz.deleteTenant(tenant);
   }

   /**
    * 更新租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public int updateTenant(UpdateTenantReqVo tenant){

        return tenantBiz.updateTenant(tenant);
   }

   /**
   * 更新租户状态
   *
   * @param tenant 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2024-10-08 14:26:31
   */
  @Override
  public int updateTenantStatus(UpdateTenantStatusReqVo tenant){

       return tenantBiz.updateTenantStatus(tenant);
  }

   /**
    * 查询租户详情
    *
    * @param tenant 请求参数
    * @return TenantResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryTenantDetailRespVo queryTenantDetail(QueryTenantDetailReqVo tenant){

       return tenantBiz.queryTenantDetail(tenant);
   }

   /**
    * 查询租户列表
    *
    * @param tenant 请求参数
    * @return TenantResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   @Override
   public QueryTenantListRespVo queryTenantList(QueryTenantListReqVo tenant){

        return tenantBiz.queryTenantList(tenant);
   }

}