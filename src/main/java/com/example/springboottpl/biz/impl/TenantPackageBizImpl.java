package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.TenantPackageBean;
import com.example.springboottpl.vo.req.*;

import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.dao.TenantPackageDao;
import com.example.springboottpl.biz.TenantPackageBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Service
public class TenantPackageBizImpl implements TenantPackageBiz {

   @Autowired
   private TenantPackageDao tenantPackageDao;

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
        TenantPackageBean bean = new TenantPackageBean();
        bean.setPackageName(tenantPackage.getPackageName());
        bean.setMenuIds(tenantPackage.getMenuIds());
        bean.setMenuCheckStrictly(tenantPackage.getMenuCheckStrictly());
        bean.setStatus(tenantPackage.getStatus());
        bean.setDelFlag(tenantPackage.getDelFlag());
        bean.setRemark(tenantPackage.getRemark());

        return tenantPackageDao.addTenantPackage(bean);
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
		return tenantPackageDao.deleteTenantPackage(tenantPackage.getIds());
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
        TenantPackageBean bean = new TenantPackageBean();
        bean.setPackageId(tenantPackage.getPackageId());
        bean.setPackageName(tenantPackage.getPackageName());
        bean.setMenuIds(tenantPackage.getMenuIds());
        bean.setMenuCheckStrictly(tenantPackage.getMenuCheckStrictly());
        bean.setStatus(tenantPackage.getStatus());
        bean.setDelFlag(tenantPackage.getDelFlag());
        bean.setRemark(tenantPackage.getRemark());
        return tenantPackageDao.updateTenantPackage(bean);
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
        TenantPackageBean bean = new TenantPackageBean();
        //bean.setPackageId(tenantPackage.getPackageId());
        //bean.setPackageName(tenantPackage.getPackageName());
        //bean.setMenuIds(tenantPackage.getMenuIds());
        //bean.setMenuCheckStrictly(tenantPackage.getMenuCheckStrictly());
        //bean.setStatus(tenantPackage.getStatus());
        //bean.setDelFlag(tenantPackage.getDelFlag());

        return tenantPackageDao.updateTenantPackageStatus(bean);
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
        TenantPackageBean bean = new TenantPackageBean();
        bean.setPackageId(tenantPackage.getPackageId());
        //bean.setPackageName(tenantPackage.getPackageName());
        //bean.setMenuIds(tenantPackage.getMenuIds());
        //bean.setMenuCheckStrictly(tenantPackage.getMenuCheckStrictly());
        //bean.setStatus(tenantPackage.getStatus());
        //bean.setDelFlag(tenantPackage.getDelFlag());

        TenantPackageBean query = tenantPackageDao.queryTenantPackageDetail(bean);

        return QueryTenantPackageDetailRespVo.builder().build();
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
        TenantPackageBean bean = new TenantPackageBean();
        //bean.setPackageName(tenantPackage.getPackageName());
        //bean.setMenuIds(tenantPackage.getMenuIds());
        //bean.setMenuCheckStrictly(tenantPackage.getMenuCheckStrictly());
        //bean.setStatus(tenantPackage.getStatus());
        //bean.setDelFlag(tenantPackage.getDelFlag());

        PageHelper.startPage(tenantPackage.getPageNum(), tenantPackage.getPageSize());
	    List<TenantPackageBean> query = tenantPackageDao.queryTenantPackageList(bean);
        PageInfo<TenantPackageBean> pageInfo = new PageInfo<>(query);

	    List<QueryTenantPackageListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryTenantPackageListRespVo resp = new QueryTenantPackageListRespVo();
            resp.setPackageId(x.getPackageId());
            resp.setPackageName(x.getPackageName());
            resp.setMenuIds(x.getMenuIds());
            resp.setMenuCheckStrictly(x.getMenuCheckStrictly());
            resp.setStatus(x.getStatus());
            resp.setDelFlag(x.getDelFlag());
            resp.setRemark(x.getRemark());
            resp.setCreateDept(x.getCreateDept());
            resp.setCreateBy(x.getCreateBy());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateBy(x.getUpdateBy());
            resp.setUpdateTime(x.getUpdateTime());
		   return resp;
	    }).collect(Collectors.toList());

        //return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
        return null;

   }
}