package com.example.springboottpl.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.MenuRole;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.MenuRoleReq;
import com.example.springboottpl.vo.req.MenuRoleListReq;
import com.example.springboottpl.vo.req.MenuRoleAddReq;
import com.example.springboottpl.vo.req.MenuRoleUpdateReq;
import com.example.springboottpl.vo.resp.MenuRoleResp;
import com.example.springboottpl.dao.MenuRoleDao;
import com.example.springboottpl.service.MenuRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:31
 */
@Service
public class MenuRoleServiceImpl implements MenuRoleService {

   @Autowired
   private MenuRoleDao menuRoleDao;
   /**
    * 查询菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return MenuRoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @Override
   public MenuRoleResp query(MenuRoleReq menuRole){

       MenuRole query = menuRoleDao.query(MenuRole.builder().build());

       return MenuRoleResp.builder().build();
   }
   /**
    * 查询菜单角色关联表列表
    *
    * @param menuRole 请求参数
    * @return MenuRoleResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @Override
   public ResultPage<MenuRoleResp> queryMenuRoleList(MenuRoleListReq menuRole){

       PageHelper.startPage(menuRole.getCurrent(), menuRole.getPageSize());
	   List<MenuRole> query = menuRoleDao.queryMenuRoleList(MenuRole.builder().build());
       PageInfo<MenuRole> pageInfo = new PageInfo<>(query);

	   List<MenuRoleResp> list = pageInfo.getList().stream().map(x -> {
		   MenuRoleResp resp = new MenuRoleResp();
		   BeanUtils.copyProperties(x, resp);
		   return resp;
	   }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
   /**
    * 添加菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @Override
   public int insert(MenuRoleAddReq menuRole){

        return menuRoleDao.insert(MenuRole.builder().build());
   }
   /**
    * 删除菜单角色关联表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @Override
   public int delete(String ids){
		return menuRoleDao.delete(Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
   }
   /**
    * 更新菜单角色关联表
    *
    * @param menuRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:31
    */
   @Override
   public int update(MenuRoleUpdateReq menuRole){

        return menuRoleDao.update(MenuRole.builder().build());
   }

}