package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.UserRoleBean;

/**
 * 描述：角色用户关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:37
 */
@Mapper
public interface UserRoleDao {

    /**
     * 添加角色用户关联
     *
     * @param userRole 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int addUserRole(UserRoleBean userRole);

    /**
     * 删除角色用户关联
     *
     * @param userId 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int deleteUserRole(List<Long> userId);

    /**
     * 更新角色用户关联
     *
     * @param userRole 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int updateUserRole(UserRoleBean userRole);

    /**
     * 更新角色用户关联状态
     *
     * @param userRole 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int updateUserRoleStatus(UserRoleBean userRole);

    /**
     * 查询角色用户关联详情
     *
     * @param userRole 请求参数
     * @return UserRole
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    UserRoleBean queryUserRoleDetail(UserRoleBean userRole);

    /**
     * 查询角色用户关联列表
     *
     * @param userRole 请求参数
     * @return List<UserRole>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    List<UserRoleBean> queryUserRoleList(UserRoleBean userRole);


    /**
     * 通过角色id查询角色使用数量
     *
     * @param userId 请求参数
     * @return List<UserRole>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    Integer countUserRoleByRoleId(Long userId);

    /**
     * 通过角色id和用户id删除
     *
     * @param userId 请求参数
     * @return List<UserRole>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:37
     */
    int deleteUseRoleByRoleIdUserId(Long roleId, Long userId);
}
