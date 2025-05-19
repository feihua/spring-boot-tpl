package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.tpl.system.entity.RoleDeptBean;

/**
 * 描述：角色和部门关联
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface RoleDeptDao {

    /**
     * 添加角色和部门关联
     *
     * @param roleDept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addRoleDept(RoleDeptBean roleDept);

    /**
     * 删除角色和部门关联
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteRoleDept(List<Long> ids);

    /**
     * 更新角色和部门关联
     *
     * @param roleDept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateRoleDept(RoleDeptBean roleDept);

    /**
     * 更新角色和部门关联状态
     *
     * @param roleDept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateRoleDeptStatus(RoleDeptBean roleDept);

    /**
     * 查询角色和部门关联详情
     *
     * @param roleDept 请求参数
     * @return RoleDept
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    RoleDeptBean queryRoleDeptDetail(RoleDeptBean roleDept);

    /**
     * 查询角色和部门关联列表
     *
     * @param roleDept 请求参数
     * @return List<RoleDept>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<RoleDeptBean> queryRoleDeptList(RoleDeptBean roleDept);

}
