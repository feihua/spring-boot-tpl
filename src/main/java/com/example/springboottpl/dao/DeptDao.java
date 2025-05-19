package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.tpl.system.entity.DeptBean;
import com.example.tpl.system.vo.req.UpdateDeptStatusReqVo;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface DeptDao {

    /**
     * 添加部门
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addDept(DeptBean dept);

    /**
     * 删除部门
     *
     * @param id 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteDept(long id);

    /**
     * 更新部门
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateDept(DeptBean dept);

    /**
     * 更新部门状态
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateDeptStatus(UpdateDeptStatusReqVo dept);

    /**
     * 查询部门详情
     *
     * @param dept 请求参数
     * @return Dept
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DeptBean queryDeptDetail(DeptBean dept);

    /**
     * 根据部门id查询部门信息
     *
     * @param id 部门id
     * @return Dept
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DeptBean queryDeptById(@Param("id")Long id);


    /**
     * 根据部门名称查询部门信息
     *
     * @param deptName 部门名称
     * @return Dept
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DeptBean queryDeptByName(@Param("deptName")String deptName, @Param("parentId")Long parentId);

    /**
     * 查询部门列表
     *
     * @param dept 请求参数
     * @return List<Dept>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<DeptBean> queryDeptList(DeptBean dept);

    /**
     * 根据部门id查询是否有下级部门
     *
     * @param id 请求参数
     * @return List<Dept>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int queryNormalChildrenDeptById(@Param("id") Long id);

    /**
     * 根据父部门id查询下级部门数量
     *
     * @param parentId 请求参数
     * @return List<Dept>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int queryDeptCount(@Param("parentId") Long parentId);

    /**
     * 查询部门是否存在用户
     *
     * @param id 请求参数
     * @return List<Dept>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int checkDeptExistUser(@Param("id") Long id);

    /**
     * 根据部门id查询是所有下级部门
     *
     * @param id 请求参数
     * @return List<Dept>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<DeptBean> queryChildrenDeptById(@Param("id") Long id);

}
