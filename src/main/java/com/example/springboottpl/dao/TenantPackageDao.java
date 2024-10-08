package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.TenantPackageBean;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Mapper
public interface TenantPackageDao {

   /**
    * 添加租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int addTenantPackage(TenantPackageBean tenantPackage);

   /**
    * 删除租户套餐
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int deleteTenantPackage(List<Long> ids);

   /**
    * 更新租户套餐
    *
    * @param tenantPackage 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenantPackage(TenantPackageBean tenantPackage);

   /**
    * 更新租户套餐状态
    *
    * @param ids 主键
    * @param status 状态
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   int updateTenantPackageStatus(List<Long> ids, int status);

   /**
    * 查询租户套餐详情
    *
    * @param tenantPackage 请求参数
    * @return TenantPackage
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   TenantPackageBean queryTenantPackageDetail(TenantPackageBean tenantPackage);

   /**
    * 查询租户套餐列表
    *
    * @param tenantPackage 请求参数
    * @return List<TenantPackage>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   List<TenantPackageBean> queryTenantPackageList(TenantPackageBean tenantPackage);

   /**
    * 查询租户套餐下拉选列表
    *
    * @return TenantPackageResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:31
    */
   List<TenantPackageBean> queryAllList();

}
