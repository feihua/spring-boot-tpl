package com.example.springboottpl.biz;

import java.util.List;
import java.util.Map;

import com.example.springboottpl.entity.TenantBean;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
public interface TenantBiz {

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
    * @return TenantResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   QueryTenantDetailRespVo queryTenantDetail(QueryTenantDetailReqVo tenant);

   /**
    * 查询租户列表
    *
    * @param tenant 请求参数
    * @return ResultPage<TenantResp>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   QueryTenantListRespVo queryTenantList(QueryTenantListReqVo tenant);

   /**
    * 根据租户id查询租户列表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   List<TenantBean> queryTenantListByIds(List<Long> ids);

}