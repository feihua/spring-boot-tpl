package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.tpl.system.entity.RoleMenuBean;

/**
 * 描述：菜单角色关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface RoleMenuDao {

    /**
     * 添加菜单角色关联
     *
     * @param roleMenu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addRoleMenu(RoleMenuBean roleMenu);

    /**
     * 删除菜单角色关联
     *
     * @param roleId 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteRoleMenu(List<Long> roleId);

    /**
     * 更新菜单角色关联
     *
     * @param roleMenu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateRoleMenu(RoleMenuBean roleMenu);

    /**
     * 更新菜单角色关联状态
     *
     * @param roleMenu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateRoleMenuStatus(RoleMenuBean roleMenu);

    /**
     * 查询菜单角色关联详情
     *
     * @param roleMenu 请求参数
     * @return RoleMenu
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    RoleMenuBean queryRoleMenuDetail(RoleMenuBean roleMenu);

    /**
     * 查询菜单角色关联列表
     *
     * @param roleMenu 请求参数
     * @return List<RoleMenu>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<RoleMenuBean> queryRoleMenuList(RoleMenuBean roleMenu);

    /**
     * 查询菜单使用数量
     *
     * @param menuId 请求参数
     * @return Long
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    Long countMenuByMenuId(@Param("menuId")Long menuId);

    /**
     * 根据roleId查询菜单menuIds
     *
     * @param roleId 请求参数
     * @return Long
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<Long> queryMenuByRoleId(@Param("roleId")Long roleId);
}
