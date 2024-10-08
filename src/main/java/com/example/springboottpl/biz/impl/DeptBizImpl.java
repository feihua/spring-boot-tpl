package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.DeptBean;
import com.example.springboottpl.vo.req.*;

import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.dao.DeptDao;
import com.example.springboottpl.biz.DeptBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Service
public class DeptBizImpl implements DeptBiz {

   @Autowired
   private DeptDao deptDao;

   /**
    * 添加部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int addDept(AddDeptReqVo dept){
        DeptBean bean = new DeptBean();
        bean.setTenantId(dept.getTenantId());
        bean.setParentId(dept.getParentId());
        bean.setParentIds(dept.getParentIds());
        bean.setDeptName(dept.getDeptName());
        bean.setDeptCategory(dept.getDeptCategory());
        bean.setOrderNum(dept.getOrderNum());
        bean.setLeader(dept.getLeader());
        bean.setPhone(dept.getPhone());
        bean.setEmail(dept.getEmail());
        bean.setStatus(dept.getStatus());
        bean.setDelFlag(dept.getDelFlag());

        return deptDao.addDept(bean);
   }

   /**
    * 删除部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int deleteDept(DeleteDeptReqVo dept){
		return deptDao.deleteDept(dept.getIds());
   }

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int updateDept(UpdateDeptReqVo dept){
        DeptBean bean = new DeptBean();
        bean.setDeptId(dept.getDeptId());
        bean.setTenantId(dept.getTenantId());
        bean.setParentId(dept.getParentId());
        bean.setParentIds(dept.getParentIds());
        bean.setDeptName(dept.getDeptName());
        bean.setDeptCategory(dept.getDeptCategory());
        bean.setOrderNum(dept.getOrderNum());
        bean.setLeader(dept.getLeader());
        bean.setPhone(dept.getPhone());
        bean.setEmail(dept.getEmail());
        bean.setStatus(dept.getStatus());
        bean.setDelFlag(dept.getDelFlag());
        return deptDao.updateDept(bean);
   }

   /**
    * 更新部门状态
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int updateDeptStatus(UpdateDeptStatusReqVo dept){
        DeptBean bean = new DeptBean();
        //bean.setDeptId(dept.getDeptId());
        //bean.setTenantId(dept.getTenantId());
        //bean.setParentId(dept.getParentId());
        //bean.setParentIds(dept.getParentIds());
        //bean.setDeptName(dept.getDeptName());
        //bean.setDeptCategory(dept.getDeptCategory());
        //bean.setOrderNum(dept.getOrderNum());
        //bean.setLeader(dept.getLeader());
        //bean.setPhone(dept.getPhone());
        //bean.setEmail(dept.getEmail());
        //bean.setStatus(dept.getStatus());
        //bean.setDelFlag(dept.getDelFlag());

        return deptDao.updateDeptStatus(bean);
   }

   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDeptDetailRespVo queryDeptDetail(QueryDeptDetailReqVo dept){
        DeptBean bean = new DeptBean();
        bean.setDeptId(dept.getDeptId());
        //bean.setTenantId(dept.getTenantId());
        //bean.setParentId(dept.getParentId());
        //bean.setParentIds(dept.getParentIds());
        //bean.setDeptName(dept.getDeptName());
        //bean.setDeptCategory(dept.getDeptCategory());
        //bean.setOrderNum(dept.getOrderNum());
        //bean.setLeader(dept.getLeader());
        //bean.setPhone(dept.getPhone());
        //bean.setEmail(dept.getEmail());
        //bean.setStatus(dept.getStatus());
        //bean.setDelFlag(dept.getDelFlag());

        DeptBean query = deptDao.queryDeptDetail(bean);

        return QueryDeptDetailRespVo.builder().build();
   }

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDeptListRespVo queryDeptList(QueryDeptListReqVo dept){
        DeptBean bean = new DeptBean();
        //bean.setTenantId(dept.getTenantId());
        //bean.setParentId(dept.getParentId());
        //bean.setParentIds(dept.getParentIds());
        //bean.setDeptName(dept.getDeptName());
        //bean.setDeptCategory(dept.getDeptCategory());
        //bean.setOrderNum(dept.getOrderNum());
        //bean.setLeader(dept.getLeader());
        //bean.setPhone(dept.getPhone());
        //bean.setEmail(dept.getEmail());
        //bean.setStatus(dept.getStatus());
        //bean.setDelFlag(dept.getDelFlag());

        PageHelper.startPage(dept.getPageNum(), dept.getPageSize());
	    List<DeptBean> query = deptDao.queryDeptList(bean);
        PageInfo<DeptBean> pageInfo = new PageInfo<>(query);

	    List<QueryDeptListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryDeptListRespVo resp = new QueryDeptListRespVo();
            resp.setDeptId(x.getDeptId());
            resp.setTenantId(x.getTenantId());
            resp.setParentId(x.getParentId());
            resp.setParentIds(x.getParentIds());
            resp.setDeptName(x.getDeptName());
            resp.setDeptCategory(x.getDeptCategory());
            resp.setOrderNum(x.getOrderNum());
            resp.setLeader(x.getLeader());
            resp.setPhone(x.getPhone());
            resp.setEmail(x.getEmail());
            resp.setStatus(x.getStatus());
            resp.setDelFlag(x.getDelFlag());
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