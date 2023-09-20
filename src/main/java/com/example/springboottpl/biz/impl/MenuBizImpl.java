package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.MenuBiz;
import com.example.springboottpl.dao.MenuDao;
import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.vo.req.MenuAddReqVo;
import com.example.springboottpl.vo.req.MenuDeleteReqVo;
import com.example.springboottpl.vo.req.MenuReqVo;
import com.example.springboottpl.vo.req.MenuUpdateReqVo;
import com.example.springboottpl.vo.resp.MenuRespVo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:24
 */
@Service
public class MenuBizImpl implements MenuBiz {

	@Autowired
	private MenuDao menuDao;

	/**
	 * 添加菜单信息
	 *
	 * @param menu 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:24
	 */
	@Override
	public int saveMenu(MenuAddReqVo menu) {
		MenuBean bean = new MenuBean();
		bean.setMenuName(menu.getMenuName());
		bean.setMenuType(menu.getMenuType());
		bean.setStatusId(menu.getStatusId());
		bean.setSort(menu.getSort());
		bean.setParentId(menu.getParentId());
		bean.setMenuUrl(menu.getMenuUrl());
		bean.setApiUrl(menu.getApiUrl());
		bean.setMenuIcon(menu.getMenuIcon());
		bean.setRemark(menu.getRemark());

		return menuDao.saveMenu(bean);
	}

	/**
	 * 删除菜单信息
	 *
	 * @param menu 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:24
	 */
	@Override
	public int deleteMenu(MenuDeleteReqVo menu) {
		return menuDao.deleteMenu(menu.getIds());
	}

	/**
	 * 更新菜单信息
	 *
	 * @param menu 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:24
	 */
	@Override
	public int updateMenu(MenuUpdateReqVo menu) {
		MenuBean bean = new MenuBean();
		bean.setId(menu.getId());
		bean.setMenuName(menu.getMenuName());
		bean.setMenuType(menu.getMenuType());
		bean.setStatusId(menu.getStatusId());
		bean.setSort(menu.getSort());
		bean.setParentId(menu.getParentId());
		bean.setMenuUrl(menu.getMenuUrl());
		bean.setApiUrl(menu.getApiUrl());
		bean.setMenuIcon(menu.getMenuIcon());
		bean.setRemark(menu.getRemark());

		return menuDao.updateMenu(bean);
	}

	/**
	 * 查询菜单信息
	 *
	 * @param menu 请求参数
	 * @return MenuResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:24
	 */
	@Override
	public MenuRespVo queryMenu(MenuReqVo menu) {
		MenuBean bean = new MenuBean();
		//bean.setId(menu.getId());
		//bean.setMenuName(menu.getMenuName());
		//bean.setMenuType(menu.getMenuType());
		//bean.setStatusId(menu.getStatusId());
		//bean.setSort(menu.getSort());
		//bean.setParentId(menu.getParentId());
		//bean.setMenuUrl(menu.getMenuUrl());
		//bean.setApiUrl(menu.getApiUrl());
		//bean.setMenuIcon(menu.getMenuIcon());
		//bean.setRemark(menu.getRemark());
		//bean.setCreateTime(menu.getCreateTime());
		//bean.setUpdateTime(menu.getUpdateTime());

		MenuBean query = menuDao.queryMenu(bean);

		return MenuRespVo.builder().build();
	}

	/**
     * 查询菜单信息列表
     *
     * @return MenuResp
     * @author 刘飞华
     * @date: 2023-09-20 10:44:24
     */
	@Override
	public List<MenuRespVo> queryMenuList() {

		return menuDao.queryMenuList(MenuBean.builder().build()).stream().map(x -> {
			MenuRespVo resp = new MenuRespVo();
			resp.setId(x.getId());
			resp.setMenuName(x.getMenuName());
			resp.setMenuType(x.getMenuType());
			resp.setStatusId(x.getStatusId());
			resp.setSort(x.getSort());
			resp.setParentId(x.getParentId());
			resp.setMenuUrl(x.getMenuUrl());
			resp.setApiUrl(x.getApiUrl());
			resp.setMenuIcon(x.getMenuIcon());
			resp.setRemark(x.getRemark());
			resp.setCreateTime(x.getCreateTime());
			resp.setUpdateTime(x.getUpdateTime());
			return resp;
		}).collect(Collectors.toList());

	}

	/**
	 * 查询菜单信息列表
	 *
	 * @return ResultPage<MenuResp>
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:24
	 */
	@Override
	public List<MenuBean> queryMenuListMenuBean() {

		return menuDao.queryMenuList(new MenuBean());
	}
}