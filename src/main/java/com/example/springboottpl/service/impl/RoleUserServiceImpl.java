package com.example.springboottpl.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.RoleUser;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleUserReq;
import com.example.springboottpl.vo.req.RoleUserListReq;
import com.example.springboottpl.vo.req.RoleUserAddReq;
import com.example.springboottpl.vo.req.RoleUserUpdateReq;
import com.example.springboottpl.vo.resp.RoleUserResp;
import com.example.springboottpl.dao.RoleUserDao;
import com.example.springboottpl.service.RoleUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:28
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

   @Autowired
   private RoleUserDao roleUserDao;
   /**
    * 查询角色用户关联表
    *
    * @param roleUser 请求参数
    * @return RoleUserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @Override
   public RoleUserResp query(RoleUserReq roleUser){

       RoleUser query = roleUserDao.query(RoleUser.builder().build());

       return RoleUserResp.builder().build();
   }
   /**
    * 查询角色用户关联表列表
    *
    * @param roleUser 请求参数
    * @return RoleUserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @Override
   public ResultPage<RoleUserResp> queryRoleUserList(RoleUserListReq roleUser){

       PageHelper.startPage(roleUser.getCurrent(), roleUser.getPageSize());
	   List<RoleUser> query = roleUserDao.queryRoleUserList(RoleUser.builder().build());
       PageInfo<RoleUser> pageInfo = new PageInfo<>(query);

	   List<RoleUserResp> list = pageInfo.getList().stream().map(x -> {
		   RoleUserResp resp = new RoleUserResp();
		   BeanUtils.copyProperties(x, resp);
		   return resp;
	   }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
   /**
    * 添加角色用户关联表
    *
    * @param roleUser 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @Override
   public int insert(RoleUserAddReq roleUser){

        return roleUserDao.insert(RoleUser.builder().build());
   }
   /**
    * 删除角色用户关联表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @Override
   public int delete(String ids){
		return roleUserDao.delete(Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
   }
   /**
    * 更新角色用户关联表
    *
    * @param roleUser 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   @Override
   public int update(RoleUserUpdateReq roleUser){

        return roleUserDao.update(RoleUser.builder().build());
   }

}