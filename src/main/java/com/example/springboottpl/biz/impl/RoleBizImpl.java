package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.RoleBean;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleReqVo;
import com.example.springboottpl.vo.req.RoleListReqVo;
import com.example.springboottpl.vo.req.RoleAddReqVo;
import com.example.springboottpl.vo.req.RoleDeleteReqVo;
import com.example.springboottpl.vo.req.RoleUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleRespVo;
import com.example.springboottpl.dao.RoleDao;
import com.example.springboottpl.biz.RoleBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Service
public class RoleBizImpl implements RoleBiz {

   @Autowired
   private RoleDao roleDao;

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int saveRole(RoleAddReqVo role){
        RoleBean bean = new RoleBean();
        bean.setId(role.getId());
        bean.setRoleName(role.getRoleName());
        bean.setStatusId(role.getStatusId());
        bean.setSort(role.getSort());
        bean.setRemark(role.getRemark());
        bean.setCreateTime(role.getCreateTime());
        bean.setUpdateTime(role.getUpdateTime());

        return roleDao.saveRole(bean);
   }

   /**
    * 删除角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int deleteRole(RoleDeleteReqVo role){
		return roleDao.deleteRole(role.getIds());
   }

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int updateRole(RoleUpdateReqVo role){
        RoleBean bean = new RoleBean();
        bean.setId(role.getId());
        bean.setRoleName(role.getRoleName());
        bean.setStatusId(role.getStatusId());
        bean.setSort(role.getSort());
        bean.setRemark(role.getRemark());
        bean.setCreateTime(role.getCreateTime());
        bean.setUpdateTime(role.getUpdateTime());

        return roleDao.updateRole(bean);
   }

   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public RoleRespVo queryRole(RoleReqVo role){
        RoleBean bean = new RoleBean();
        //bean.setId(role.getId());
        //bean.setRoleName(role.getRoleName());
        //bean.setStatusId(role.getStatusId());
        //bean.setSort(role.getSort());
        //bean.setRemark(role.getRemark());
        //bean.setCreateTime(role.getCreateTime());
        //bean.setUpdateTime(role.getUpdateTime());

        RoleBean query = roleDao.queryRole(bean);

        return RoleRespVo.builder().build();
   }

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public ResultPage<RoleRespVo> queryRoleList(RoleListReqVo role){
        RoleBean bean = new RoleBean();
        //bean.setId(role.getId());
        //bean.setRoleName(role.getRoleName());
        //bean.setStatusId(role.getStatusId());
        //bean.setSort(role.getSort());
        //bean.setRemark(role.getRemark());
        //bean.setCreateTime(role.getCreateTime());
        //bean.setUpdateTime(role.getUpdateTime());

        PageHelper.startPage(role.getPageNum(), role.getPageSize());
	    List<RoleBean> query = roleDao.queryRoleList(bean);
        PageInfo<RoleBean> pageInfo = new PageInfo<>(query);

	    List<RoleRespVo> list = pageInfo.getList().stream().map(x -> {
            RoleRespVo resp = new RoleRespVo();
            resp.setId(x.getId());
            resp.setRoleName(x.getRoleName());
            resp.setStatusId(x.getStatusId());
            resp.setSort(x.getSort());
            resp.setRemark(x.getRemark());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateTime(x.getUpdateTime());
		   return resp;
	    }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
}