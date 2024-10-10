package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
public interface TenantService {

   /**
    * 添加租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int addTenant(AddTenantReqVo tenant);

   /**
    * 删除租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int deleteTenant(DeleteTenantReqVo tenant);

   /**
    * 更新租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenant(UpdateTenantReqVo tenant);

   /**
    * 更新租户状态
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenantStatus(UpdateTenantStatusReqVo tenant);


   /**
    * 查询租户详情
    *
    * @param tenant 请求参数
    * @return QueryTenantDetailResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   QueryTenantDetailRespVo queryTenantDetail(QueryTenantDetailReqVo tenant);

   /**
    * 查询租户列表
    *
    * @param tenant 请求参数
    * @return QueryTenantListResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   ResultPage<QueryTenantListRespVo> queryTenantList(QueryTenantListReqVo tenant);

}