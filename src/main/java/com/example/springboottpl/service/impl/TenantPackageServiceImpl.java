package com.example.springboottpl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.TenantBiz;
import com.example.springboottpl.biz.TenantPackageBiz;
import com.example.springboottpl.entity.TenantBean;
import com.example.springboottpl.enums.ExceptionEnum;
import com.example.springboottpl.exception.TplException;
import com.example.springboottpl.service.TenantPackageService;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddTenantPackageReqVo;
import com.example.springboottpl.vo.req.DeleteTenantPackageReqVo;
import com.example.springboottpl.vo.req.QueryTenantPackageDetailReqVo;
import com.example.springboottpl.vo.req.QueryTenantPackageListReqVo;
import com.example.springboottpl.vo.req.UpdateTenantPackageReqVo;
import com.example.springboottpl.vo.req.UpdateTenantPackageStatusReqVo;
import com.example.springboottpl.vo.resp.QueryTenantPackageDetailRespVo;
import com.example.springboottpl.vo.resp.QueryTenantPackageListRespVo;

/**
 * 描述：租户套餐
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:31
 */
@Service
public class TenantPackageServiceImpl implements TenantPackageService {

    @Autowired
    private TenantPackageBiz tenantPackageBiz;

    @Autowired
    private TenantBiz tenantBiz;

    /**
     * 添加租户套餐
     *
     * @param tenantPackage 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2024-10-08 14:26:31
     */
    @Override
    public int addTenantPackage(AddTenantPackageReqVo tenantPackage) {

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
    public int deleteTenantPackage(DeleteTenantPackageReqVo tenantPackage) {
        List<TenantBean> list = tenantBiz.queryTenantListByIds(tenantPackage.getIds());
        if (!list.isEmpty()) {
            throw new TplException(ExceptionEnum.ERROR.getCode(), "租户套餐已被使用");
        }
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
    public int updateTenantPackage(UpdateTenantPackageReqVo tenantPackage) {

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
    public int updateTenantPackageStatus(UpdateTenantPackageStatusReqVo tenantPackage) {

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
    public QueryTenantPackageDetailRespVo queryTenantPackageDetail(QueryTenantPackageDetailReqVo tenantPackage) {

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
    public ResultPage<QueryTenantPackageListRespVo> queryTenantPackageList(QueryTenantPackageListReqVo tenantPackage) {

        return tenantPackageBiz.queryTenantPackageList(tenantPackage);
    }

    /**
     * 查询租户套餐下拉选列表
     *
     * @return TenantPackageResp
     * @author 刘飞华
     * @date: 2024-10-08 14:26:31
     */
    @Override
    public List<QueryTenantPackageDetailRespVo> queryAllList() {
        return tenantPackageBiz.queryAllList();
    }
}