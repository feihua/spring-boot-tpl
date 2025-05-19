package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.tpl.system.entity.MenuBean;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2025/01/14 10:40:16
 */
@Mapper
public interface MenuDao {

    /**
     * 添加菜单信息
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    int addMenu(MenuBean menu);

    /**
     * 删除菜单信息
     *
     * @param id 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    int deleteMenu(Long id);

    /**
     * 更新菜单信息
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    int updateMenu(MenuBean menu);

    /**
     * 更新菜单信息状态
     *
     * @param menu 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    int updateMenuStatus(MenuBean menu);

    /**
     * 查询菜单信息详情
     *
     * @param menu 请求参数
     * @return Menu
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    MenuBean queryMenuDetail(MenuBean menu);

    /**
     * 根据id查询菜单信息详情
     *
     * @param id 请求参数
     * @return Menu
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    MenuBean queryMenuById(@Param("id")Long id);

    /**
     * 根据menu_name查询菜单信息详情
     *
     * @param menuName 请求参数
     * @return Menu
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    MenuBean queryMenuByName(@Param("menuName")String menuName);

    /**
     * 根据menu_url查询菜单信息详情
     *
     * @param menuUrl 请求参数
     * @return Menu
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    MenuBean queryMenuByUrl(@Param("menuUrl")String menuUrl);


    /**
     * 查询菜单信息列表
     *
     * @param menu 请求参数
     * @return List<Menu>
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    List<MenuBean> queryMenuList(MenuBean menu);


    /**
     * 查询菜单数量
     *
     * @param parentId 请求参数
     * @return List<Menu>
     * @author 刘飞华
     * @date: 2025/01/14 10:40:16
     */
    Long countMenuByParentId(Long parentId);
}
