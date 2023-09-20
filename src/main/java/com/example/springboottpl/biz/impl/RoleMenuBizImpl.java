package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.RoleMenuBean;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.RoleMenuReqVo;
import com.example.springboottpl.vo.req.RoleMenuListReqVo;
import com.example.springboottpl.vo.req.RoleMenuAddReqVo;
import com.example.springboottpl.vo.req.RoleMenuDeleteReqVo;
import com.example.springboottpl.vo.req.RoleMenuUpdateReqVo;
import com.example.springboottpl.vo.resp.RoleMenuRespVo;
import com.example.springboottpl.dao.RoleMenuDao;
import com.example.springboottpl.biz.RoleMenuBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：菜单角色关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Service
public class RoleMenuBizImpl implements RoleMenuBiz {

   @Autowired
   private RoleMenuDao roleMenuDao;

   /**
    * 添加菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int saveRoleMenu(RoleMenuAddReqVo roleMenu){
        RoleMenuBean bean = new RoleMenuBean();
        bean.setId(roleMenu.getId());
        bean.setRoleId(roleMenu.getRoleId());
        bean.setMenuId(roleMenu.getMenuId());
        bean.setStatusId(roleMenu.getStatusId());
        bean.setSort(roleMenu.getSort());
        bean.setCreateTime(roleMenu.getCreateTime());
        bean.setUpdateTime(roleMenu.getUpdateTime());

        return roleMenuDao.saveRoleMenu(bean);
   }

   /**
    * 删除菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int deleteRoleMenu(RoleMenuDeleteReqVo roleMenu){
		return roleMenuDao.deleteRoleMenu(roleMenu.getIds());
   }

   /**
    * 更新菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public int updateRoleMenu(RoleMenuUpdateReqVo roleMenu){
        RoleMenuBean bean = new RoleMenuBean();
        bean.setId(roleMenu.getId());
        bean.setRoleId(roleMenu.getRoleId());
        bean.setMenuId(roleMenu.getMenuId());
        bean.setStatusId(roleMenu.getStatusId());
        bean.setSort(roleMenu.getSort());
        bean.setCreateTime(roleMenu.getCreateTime());
        bean.setUpdateTime(roleMenu.getUpdateTime());

        return roleMenuDao.updateRoleMenu(bean);
   }

   /**
    * 查询菜单角色关联表
    *
    * @param roleMenu 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public RoleMenuRespVo queryRoleMenu(RoleMenuReqVo roleMenu){
        RoleMenuBean bean = new RoleMenuBean();
        //bean.setId(roleMenu.getId());
        //bean.setRoleId(roleMenu.getRoleId());
        //bean.setMenuId(roleMenu.getMenuId());
        //bean.setStatusId(roleMenu.getStatusId());
        //bean.setSort(roleMenu.getSort());
        //bean.setCreateTime(roleMenu.getCreateTime());
        //bean.setUpdateTime(roleMenu.getUpdateTime());

        RoleMenuBean query = roleMenuDao.queryRoleMenu(bean);

        return RoleMenuRespVo.builder().build();
   }

   /**
    * 查询菜单角色关联表列表
    *
    * @param roleMenu 请求参数
    * @return RoleMenuResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   @Override
   public ResultPage<RoleMenuRespVo> queryRoleMenuList(RoleMenuListReqVo roleMenu){
        RoleMenuBean bean = new RoleMenuBean();
        //bean.setId(roleMenu.getId());
        //bean.setRoleId(roleMenu.getRoleId());
        //bean.setMenuId(roleMenu.getMenuId());
        //bean.setStatusId(roleMenu.getStatusId());
        //bean.setSort(roleMenu.getSort());
        //bean.setCreateTime(roleMenu.getCreateTime());
        //bean.setUpdateTime(roleMenu.getUpdateTime());

        PageHelper.startPage(roleMenu.getPageNum(), roleMenu.getPageSize());
	    List<RoleMenuBean> query = roleMenuDao.queryRoleMenuList(bean);
        PageInfo<RoleMenuBean> pageInfo = new PageInfo<>(query);

	    List<RoleMenuRespVo> list = pageInfo.getList().stream().map(x -> {
            RoleMenuRespVo resp = new RoleMenuRespVo();
            resp.setId(x.getId());
            resp.setRoleId(x.getRoleId());
            resp.setMenuId(x.getMenuId());
            resp.setStatusId(x.getStatusId());
            resp.setSort(x.getSort());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateTime(x.getUpdateTime());
		   return resp;
	    }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
}