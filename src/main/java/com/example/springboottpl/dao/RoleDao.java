package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboottpl.entity.RoleBean;
import com.example.springboottpl.vo.req.UpdateRoleStatusReqVo;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2025-01-14 10:40:16
 */
@Mapper
public interface RoleDao {

    /**
     * 添加角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    int addRole(RoleBean role);

    /**
     * 删除角色信息
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    int deleteRole(List<Long> ids);

    /**
     * 更新角色信息
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    int updateRole(RoleBean role);

    /**
     * 更新角色信息状态
     *
     * @param role 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    int updateRoleStatus(UpdateRoleStatusReqVo role);

    /**
     * 查询角色信息详情
     *
     * @param role 请求参数
     * @return Role
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    RoleBean queryRoleDetail(RoleBean role);

    /**
     * 根据id查询角色信息详情
     *
     * @param id 请求参数
     * @return Role
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    RoleBean queryRoleById(@Param("id")Long id);

    /**
     * 根据role_name查询角色信息
     *
     * @param roleName 请求参数
     * @return Role
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    RoleBean queryRoleByName(@Param("roleName")String roleName);


    /**
     * 根据role_key查询角色信息
     *
     * @param roleKey 请求参数
     * @return Role
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    RoleBean queryRoleByKey(@Param("roleKey")String roleKey);


    /**
     * 查询角色信息列表
     *
     * @param role 请求参数
     * @return List<Role>
     * @author 刘飞华
     * @date: 2025-01-14 10:40:16
     */
    List<RoleBean> queryRoleList(RoleBean role);

}
