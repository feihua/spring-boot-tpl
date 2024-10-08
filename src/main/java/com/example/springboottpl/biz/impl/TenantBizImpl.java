package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.TenantBean;
import com.example.springboottpl.vo.req.*;

import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.dao.TenantDao;
import com.example.springboottpl.biz.TenantBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：租户
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Service
public class TenantBizImpl implements TenantBiz {

   @Autowired
   private TenantDao tenantDao;

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
        TenantBean bean = new TenantBean();
        bean.setTenantId(tenant.getTenantId());
        bean.setContactUserName(tenant.getContactUserName());
        bean.setContactPhone(tenant.getContactPhone());
        bean.setCompanyName(tenant.getCompanyName());
        bean.setLicenseNumber(tenant.getLicenseNumber());
        bean.setAddress(tenant.getAddress());
        bean.setIntro(tenant.getIntro());
        bean.setDomain(tenant.getDomain());
        bean.setPackageId(tenant.getPackageId());
        bean.setExpireTime(tenant.getExpireTime());
        bean.setAccountCount(tenant.getAccountCount());
        bean.setStatus(tenant.getStatus());
        bean.setDelFlag(tenant.getDelFlag());
        bean.setRemark(tenant.getRemark());

        return tenantDao.addTenant(bean);
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
		return tenantDao.deleteTenant(tenant.getIds());
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
        TenantBean bean = new TenantBean();
        bean.setId(tenant.getId());
        bean.setTenantId(tenant.getTenantId());
        bean.setContactUserName(tenant.getContactUserName());
        bean.setContactPhone(tenant.getContactPhone());
        bean.setCompanyName(tenant.getCompanyName());
        bean.setLicenseNumber(tenant.getLicenseNumber());
        bean.setAddress(tenant.getAddress());
        bean.setIntro(tenant.getIntro());
        bean.setDomain(tenant.getDomain());
        bean.setPackageId(tenant.getPackageId());
        bean.setExpireTime(tenant.getExpireTime());
        bean.setAccountCount(tenant.getAccountCount());
        bean.setStatus(tenant.getStatus());
        bean.setDelFlag(tenant.getDelFlag());
        bean.setRemark(tenant.getRemark());
        return tenantDao.updateTenant(bean);
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
        TenantBean bean = new TenantBean();
        //bean.setId(tenant.getId());
        //bean.setTenantId(tenant.getTenantId());
        //bean.setContactUserName(tenant.getContactUserName());
        //bean.setContactPhone(tenant.getContactPhone());
        //bean.setCompanyName(tenant.getCompanyName());
        //bean.setLicenseNumber(tenant.getLicenseNumber());
        //bean.setAddress(tenant.getAddress());
        //bean.setIntro(tenant.getIntro());
        //bean.setDomain(tenant.getDomain());
        //bean.setPackageId(tenant.getPackageId());
        //bean.setExpireTime(tenant.getExpireTime());
        //bean.setAccountCount(tenant.getAccountCount());
        //bean.setStatus(tenant.getStatus());
        //bean.setDelFlag(tenant.getDelFlag());

        return tenantDao.updateTenantStatus(bean);
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
        TenantBean bean = new TenantBean();
        bean.setId(tenant.getId());
        //bean.setTenantId(tenant.getTenantId());
        //bean.setContactUserName(tenant.getContactUserName());
        //bean.setContactPhone(tenant.getContactPhone());
        //bean.setCompanyName(tenant.getCompanyName());
        //bean.setLicenseNumber(tenant.getLicenseNumber());
        //bean.setAddress(tenant.getAddress());
        //bean.setIntro(tenant.getIntro());
        //bean.setDomain(tenant.getDomain());
        //bean.setPackageId(tenant.getPackageId());
        //bean.setExpireTime(tenant.getExpireTime());
        //bean.setAccountCount(tenant.getAccountCount());
        //bean.setStatus(tenant.getStatus());
        //bean.setDelFlag(tenant.getDelFlag());

        TenantBean query = tenantDao.queryTenantDetail(bean);

        return QueryTenantDetailRespVo.builder().build();
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
        TenantBean bean = new TenantBean();
        //bean.setTenantId(tenant.getTenantId());
        //bean.setContactUserName(tenant.getContactUserName());
        //bean.setContactPhone(tenant.getContactPhone());
        //bean.setCompanyName(tenant.getCompanyName());
        //bean.setLicenseNumber(tenant.getLicenseNumber());
        //bean.setAddress(tenant.getAddress());
        //bean.setIntro(tenant.getIntro());
        //bean.setDomain(tenant.getDomain());
        //bean.setPackageId(tenant.getPackageId());
        //bean.setExpireTime(tenant.getExpireTime());
        //bean.setAccountCount(tenant.getAccountCount());
        //bean.setStatus(tenant.getStatus());
        //bean.setDelFlag(tenant.getDelFlag());

        PageHelper.startPage(tenant.getPageNum(), tenant.getPageSize());
	    List<TenantBean> query = tenantDao.queryTenantList(bean);
        PageInfo<TenantBean> pageInfo = new PageInfo<>(query);

	    List<QueryTenantListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryTenantListRespVo resp = new QueryTenantListRespVo();
            resp.setId(x.getId());
            resp.setTenantId(x.getTenantId());
            resp.setContactUserName(x.getContactUserName());
            resp.setContactPhone(x.getContactPhone());
            resp.setCompanyName(x.getCompanyName());
            resp.setLicenseNumber(x.getLicenseNumber());
            resp.setAddress(x.getAddress());
            resp.setIntro(x.getIntro());
            resp.setDomain(x.getDomain());
            resp.setPackageId(x.getPackageId());
            resp.setExpireTime(x.getExpireTime());
            resp.setAccountCount(x.getAccountCount());
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