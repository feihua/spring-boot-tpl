package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.TenantBean;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Mapper
public interface TenantDao {

   /**
    * 添加租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int addTenant(TenantBean tenant);

   /**
    * 删除租户
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int deleteTenant(List<Long> ids);

   /**
    * 更新租户
    *
    * @param tenant 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenant(TenantBean tenant);

      /**
       * 更新租户状态
       *
       * @param tenant 请求参数
       * @return int
       * @author 刘飞华
       * @date: 2024-10-08 14:26:31
       */
      int updateTenantStatus(TenantBean tenant);

   /**
    * 查询租户详情
    *
    * @param tenant 请求参数
    * @return Tenant
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   TenantBean queryTenantDetail(TenantBean tenant);

   /**
    * 查询租户列表
    *
    * @param tenant 请求参数
    * @return List<Tenant>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   List<TenantBean> queryTenantList(TenantBean tenant);


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
