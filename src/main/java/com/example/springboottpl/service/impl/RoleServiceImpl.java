package com.example.springboottpl.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.Role;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleReq;
import com.example.springboottpl.vo.req.RoleListReq;
import com.example.springboottpl.vo.req.RoleAddReq;
import com.example.springboottpl.vo.req.RoleUpdateReq;
import com.example.springboottpl.vo.resp.RoleResp;
import com.example.springboottpl.dao.RoleDao;
import com.example.springboottpl.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:29
 */
@Service
public class RoleServiceImpl implements RoleService {

   @Autowired
   private RoleDao roleDao;
   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @Override
   public RoleResp query(RoleReq role){

       Role query = roleDao.query(Role.builder().build());

       return RoleResp.builder().build();
   }
   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return RoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @Override
   public ResultPage<RoleResp> queryRoleList(RoleListReq role){

       PageHelper.startPage(role.getCurrent(), role.getPageSize());
	   List<Role> query = roleDao.queryRoleList(Role.builder().build());
       PageInfo<Role> pageInfo = new PageInfo<>(query);

	   List<RoleResp> list = pageInfo.getList().stream().map(x -> {
		   RoleResp resp = new RoleResp();
		   BeanUtils.copyProperties(x, resp);
		   return resp;
	   }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @Override
   public int insert(RoleAddReq role){

        return roleDao.insert(Role.builder().build());
   }
   /**
    * 删除角色信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @Override
   public int delete(String ids){
		return roleDao.delete(Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
   }
   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   @Override
   public int update(RoleUpdateReq role){

        return roleDao.update(Role.builder().build());
   }

}