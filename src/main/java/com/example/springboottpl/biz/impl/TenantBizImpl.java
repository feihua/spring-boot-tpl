package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.TenantBiz;
import com.example.springboottpl.dao.TenantDao;
import com.example.springboottpl.entity.TenantBean;
import com.example.springboottpl.enums.ExceptionEnum;
import com.example.springboottpl.exception.TplException;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.util.TplConstant;
import com.example.springboottpl.vo.req.AddTenantReqVo;
import com.example.springboottpl.vo.req.DeleteTenantReqVo;
import com.example.springboottpl.vo.req.QueryTenantDetailReqVo;
import com.example.springboottpl.vo.req.QueryTenantListReqVo;
import com.example.springboottpl.vo.req.UpdateTenantReqVo;
import com.example.springboottpl.vo.req.UpdateTenantStatusReqVo;
import com.example.springboottpl.vo.resp.QueryTenantDetailRespVo;
import com.example.springboottpl.vo.resp.QueryTenantListRespVo;
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
    public int addTenant(AddTenantReqVo tenant) {

        TenantBean packageBean = tenantDao.queryTenantDetail(TenantBean.builder()
                .companyName(tenant.getCompanyName())
                .build());
        if (packageBean != null) {
            throw new TplException(ExceptionEnum.ERROR.getCode(), "企业名称已存在");
        }

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
    public int deleteTenant(DeleteTenantReqVo tenant) {
        if (tenant.getIds().contains(TplConstant.SUPER_ADMIN_ID)) {
            throw new TplException(ExceptionEnum.ERROR.getCode(), "超管租户不能删除");
        }

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
    public int updateTenant(UpdateTenantReqVo tenant) {
        if (tenant.getTenantId().equals(TplConstant.DEFAULT_TENANT_ID)) {
            throw new TplException(ExceptionEnum.ERROR.getCode(), "不允许操作管理租户");
        }

        TenantBean packageBean = tenantDao.queryTenantDetail(TenantBean.builder()
                .companyName(tenant.getCompanyName())
                .build());

        if (packageBean != null && !packageBean.getTenantId().equals(tenant.getTenantId())) {
            throw new TplException(ExceptionEnum.ERROR.getCode(), "企业名称已存在");
        }

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
    public int updateTenantStatus(UpdateTenantStatusReqVo tenant) {
        if (TplConstant.DEFAULT_TENANT_ID.equals(tenant.getTenantId())) {
            throw new TplException(ExceptionEnum.ERROR.getCode(), "不允许操作管理租户");
        }
        TenantBean bean = new TenantBean();
        bean.setId(tenant.getId());
        bean.setTenantId(tenant.getTenantId());
        bean.setStatus(tenant.getStatus());

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
    public QueryTenantDetailRespVo queryTenantDetail(QueryTenantDetailReqVo tenant) {
        TenantBean bean = tenantDao.queryTenantDetail(TenantBean.builder().id(tenant.getId()).build());

        QueryTenantDetailRespVo resp = new QueryTenantDetailRespVo();
        resp.setId(bean.getId());
        resp.setTenantId(bean.getTenantId());
        resp.setContactUserName(bean.getContactUserName());
        resp.setContactPhone(bean.getContactPhone());
        resp.setCompanyName(bean.getCompanyName());
        resp.setLicenseNumber(bean.getLicenseNumber());
        resp.setAddress(bean.getAddress());
        resp.setIntro(bean.getIntro());
        resp.setDomain(bean.getDomain());
        resp.setPackageId(bean.getPackageId());
        resp.setExpireTime(bean.getExpireTime());
        resp.setAccountCount(bean.getAccountCount());
        resp.setStatus(bean.getStatus());
        resp.setDelFlag(bean.getDelFlag());
        resp.setRemark(bean.getRemark());
        resp.setCreateDept(bean.getCreateDept());
        resp.setCreateBy(bean.getCreateBy());
        resp.setCreateTime(bean.getCreateTime());
        resp.setUpdateBy(bean.getUpdateBy());
        resp.setUpdateTime(bean.getUpdateTime());

        return resp;
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
    public ResultPage<QueryTenantListRespVo> queryTenantList(QueryTenantListReqVo tenant) {
        TenantBean bean = new TenantBean();
        bean.setTenantId(tenant.getTenantId());
        bean.setContactUserName(tenant.getContactUserName());
        bean.setContactPhone(tenant.getContactPhone());
        bean.setCompanyName(tenant.getCompanyName());
        bean.setLicenseNumber(tenant.getLicenseNumber());
        bean.setPackageId(tenant.getPackageId());
        bean.setStatus(tenant.getStatus());

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

        return new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());

    }

    /**
     * 根据租户id查询租户列表
     *
     * @param ids 参数
     * @return list
     * @author 刘飞华
     * @date: 2024/10/10 13:56
     */
    @Override
    public List<TenantBean> queryTenantListByIds(List<Long> ids) {
        return tenantDao.queryTenantListByIds(ids);
    }
}