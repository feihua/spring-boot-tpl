package com.example.tpl.system.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.MenuBiz;
import com.example.tpl.system.dao.MenuDao;
import com.example.tpl.system.dao.RoleMenuDao;
import com.example.tpl.system.entity.MenuBean;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.vo.req.AddMenuReqVo;
import com.example.tpl.system.vo.req.DeleteMenuReqVo;
import com.example.tpl.system.vo.req.QueryMenuDetailReqVo;
import com.example.tpl.system.vo.req.QueryMenuListReqVo;
import com.example.tpl.system.vo.req.UpdateMenuReqVo;
import com.example.tpl.system.vo.req.UpdateMenuStatusReqVo;
import com.example.tpl.system.vo.resp.QueryMenuDetailRespVo;
import com.example.tpl.system.vo.resp.QueryMenuListRespVo;
import com.example.tpl.system.vo.resp.QueryMenuSimpleListRespVo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025-01-14 10:40:16
 */
@Service
public class MenuBizImpl implements MenuBiz {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    /**
     * 添加菜单信息
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> addMenu(AddMenuReqVo menu) {
        String menuName = menu.getMenuName();
        String menuUrl = menu.getMenuUrl();

        MenuBean menuBean = menuDao.queryMenuByName(menuName);
        if (menuBean != null) {
            return Result.error("添加菜单失败,菜单名称已存在");
        }

        if (StringUtils.isNotBlank(menuUrl)) {
            MenuBean res = menuDao.queryMenuByUrl(menuUrl);
            if (res != null) {
                return Result.error("添加菜单失败,路由路径已存在");
            }
        }

        MenuBean bean = new MenuBean();
        bean.setMenuName(menuName); //菜单名称
        bean.setMenuType(menu.getMenuType()); //菜单类型(1：目录   2：菜单   3：按钮)
        bean.setVisible(menu.getVisible()); //显示状态（0:隐藏, 显示:1）
        bean.setStatus(menu.getStatus()); //菜单状态(1:正常，0:禁用)
        bean.setSort(menu.getSort()); //排序
        bean.setParentId(menu.getParentId()); //父ID
        bean.setMenuUrl(menuUrl); //路由路径
        bean.setApiUrl(menu.getApiUrl()); //接口URL
        bean.setMenuIcon(menu.getMenuIcon()); //菜单图标
        bean.setRemark(menu.getRemark()); //备注

        int i = menuDao.addMenu(bean);
        return Result.success(i);
    }

    /**
     * 删除菜单信息
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> deleteMenu(DeleteMenuReqVo menu) {
        Long count = menuDao.countMenuByParentId(menu.getId());
        if (count > 0) {
            return Result.error("存在子菜单,不允许删除");
        }

        Long count1 = roleMenuDao.countMenuByMenuId(menu.getId());
        if (count1 > 0) {
            return Result.error("菜单已分配,不允许删除");
        }

        int i = menuDao.deleteMenu(menu.getId());
        return Result.success(i);
    }

    /**
     * 更新菜单信息
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> updateMenu(UpdateMenuReqVo menu) {
        Long id = menu.getId();
        String menuName = menu.getMenuName();
        String menuUrl = menu.getMenuUrl();

        MenuBean res = menuDao.queryMenuById(id);
        if (res == null) {
            return Result.error("更新菜单信息失败,菜单信息不存在");
        }

        MenuBean menuBean = menuDao.queryMenuByName(menuName);
        if (menuBean != null && !menuBean.getId().equals(id)) {
            return Result.error("更新菜单信息失败,菜单名称已存在");
        }

        if (StringUtils.isNotBlank(menuUrl)) {
            MenuBean bean = menuDao.queryMenuByUrl(menuUrl);
            if (bean != null && !bean.getId().equals(id)) {
                return Result.error("更新菜单信息失败,路由路径已存在");
            }
        }

        MenuBean bean = new MenuBean();
        bean.setId(id);//主键
        bean.setMenuName(menuName);//菜单名称
        bean.setMenuType(menu.getMenuType());//菜单类型(1：目录   2：菜单   3：按钮)
        bean.setVisible(menu.getVisible());//显示状态（0:隐藏, 显示:1）
        bean.setStatus(menu.getStatus());//菜单状态(1:正常，0:禁用)
        bean.setSort(menu.getSort());//排序
        bean.setParentId(menu.getParentId());//父ID
        bean.setMenuUrl(menuUrl);//路由路径
        bean.setApiUrl(menu.getApiUrl());//接口URL
        bean.setMenuIcon(menu.getMenuIcon());//菜单图标
        bean.setRemark(menu.getRemark());//备注

        int i = menuDao.updateMenu(bean);
        return Result.success(i);
    }

    /**
     * 更新菜单信息状态
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<Integer> updateMenuStatus(UpdateMenuStatusReqVo menu) {
        MenuBean bean = new MenuBean();
        bean.setId(menu.getId());//主键
        bean.setStatus(menu.getStatus());//菜单状态(1:正常，0:禁用)

        int i = menuDao.updateMenuStatus(bean);
        return Result.success(i);
    }

    /**
     * 查询菜单信息详情
     *
     * @param menu 请求参数
     * @return MenuResp
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<QueryMenuDetailRespVo> queryMenuDetail(QueryMenuDetailReqVo menu) {
        MenuBean bean = new MenuBean();
        bean.setId(menu.getId());//主键
        //bean.setMenuName(menu.getMenuName());//菜单名称
        //bean.setMenuType(menu.getMenuType());//菜单类型(1：目录   2：菜单   3：按钮)
        //bean.setVisible(menu.getVisible());//显示状态（0:隐藏, 显示:1）
        //bean.setStatus(menu.getStatus());//菜单状态(1:正常，0:禁用)
        //bean.setParentId(menu.getParentId());//父ID
        //bean.setMenuUrl(menu.getMenuUrl());//路由路径
        //bean.setApiUrl(menu.getApiUrl());//接口URL
        //bean.setMenuIcon(menu.getMenuIcon());//菜单图标

        MenuBean menuBean = menuDao.queryMenuDetail(bean);
        if (menuBean == null) {
            return Result.error("查询菜单信息详情失败,菜单信息不存在");
        }

        QueryMenuDetailRespVo resp = new QueryMenuDetailRespVo();
        resp.setId(menuBean.getId());//主键
        resp.setMenuName(menuBean.getMenuName());//菜单名称
        resp.setMenuType(menuBean.getMenuType());//菜单类型(1：目录   2：菜单   3：按钮)
        resp.setVisible(menuBean.getVisible());//显示状态（0:隐藏, 显示:1）
        resp.setStatus(menuBean.getStatus());//菜单状态(1:正常，0:禁用)
        resp.setSort(menuBean.getSort());//排序
        resp.setParentId(menuBean.getParentId());//父ID
        resp.setMenuUrl(menuBean.getMenuUrl());//路由路径
        resp.setApiUrl(menuBean.getApiUrl());//接口URL
        resp.setMenuIcon(menuBean.getMenuIcon());//菜单图标
        resp.setRemark(menuBean.getRemark());//备注
        resp.setCreateTime(menuBean.getCreateTime());//创建时间
        resp.setUpdateTime(menuBean.getUpdateTime());//修改时间

        return Result.success(resp);
    }

    /**
     * 查询菜单信息列表
     *
     * @param menu 请求参数
     * @return MenuResp
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    @Override
    public Result<List<QueryMenuListRespVo>> queryMenuList(QueryMenuListReqVo menu) {
        MenuBean bean = new MenuBean();
        //bean.setMenuName(menu.getMenuName());//菜单名称
        //bean.setMenuType(menu.getMenuType());//菜单类型(1：目录   2：菜单   3：按钮)
        //bean.setVisible(menu.getVisible());//显示状态（0:隐藏, 显示:1）
        //bean.setStatus(menu.getStatus());//菜单状态(1:正常，0:禁用)
        //bean.setParentId(menu.getParentId());//父ID
        //bean.setMenuUrl(menu.getMenuUrl());//路由路径
        //bean.setApiUrl(menu.getApiUrl());//接口URL
        //bean.setMenuIcon(menu.getMenuIcon());//菜单图标


        List<QueryMenuListRespVo> list = menuDao.queryMenuList(bean).stream().map(x -> {
            QueryMenuListRespVo resp = new QueryMenuListRespVo();
            resp.setId(x.getId());//主键
            resp.setMenuName(x.getMenuName());//菜单名称
            resp.setMenuType(x.getMenuType());//菜单类型(1：目录   2：菜单   3：按钮)
            resp.setVisible(x.getVisible());//显示状态（0:隐藏, 显示:1）
            resp.setStatus(x.getStatus());//菜单状态(1:正常，0:禁用)
            resp.setSort(x.getSort());//排序
            resp.setParentId(x.getParentId());//父ID
            resp.setMenuUrl(x.getMenuUrl());//路由路径
            resp.setApiUrl(x.getApiUrl());//接口URL
            resp.setMenuIcon(x.getMenuIcon());//菜单图标
            resp.setRemark(x.getRemark());//备注
            resp.setCreateTime(x.getCreateTime());//创建时间
            resp.setUpdateTime(x.getUpdateTime());//修改时间
            return resp;
        }).collect(Collectors.toList());

        return Result.success(list);

    }

    /**
     * 查询菜单信息(排除按钮)
     *
     * @return List
     * @author 刘飞华
     * @date: 2025/1/20 9:10
     */
    @Override
    public Result<List<QueryMenuSimpleListRespVo>> queryMenuListSimple() {
        MenuBean bean = new MenuBean();

        List<QueryMenuSimpleListRespVo> list = menuDao.queryMenuList(bean).stream().map(x -> {
            QueryMenuSimpleListRespVo resp = new QueryMenuSimpleListRespVo();
            resp.setId(x.getId());//主键
            resp.setMenuName(x.getMenuName());//菜单名称
            resp.setParentId(x.getParentId());//父ID
            return resp;
        }).collect(Collectors.toList());

        return Result.success(list);
    }
}