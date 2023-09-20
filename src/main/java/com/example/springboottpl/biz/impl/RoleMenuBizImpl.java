package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.RoleMenuBiz;
import com.example.springboottpl.dao.RoleMenuDao;
import com.example.springboottpl.entity.RoleMenuBean;
import com.example.springboottpl.vo.req.RoleMenuAddReqVo;

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
	public int saveRoleMenu(RoleMenuAddReqVo roleMenu) {
		RoleMenuBean bean = new RoleMenuBean();
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
	 * @param roleId@return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:25
	 */
	@Override
	public int deleteRoleMenu(Integer roleId) {
		return roleMenuDao.deleteRoleMenu(roleId);
	}

	/**
	 * 查询菜单角色关联表列表
	 *
	 * @param roleId 请求参数
	 * @return RoleMenuResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:25
	 */
	@Override
	public List<Integer> queryRoleMenuList(Integer roleId) {
		return roleMenuDao.queryRoleMenuList(RoleMenuBean.builder().roleId(roleId).build()).stream().map(RoleMenuBean::getMenuId)
				.collect(Collectors.toList());

	}
}