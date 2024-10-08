package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.example.springboottpl.entity.DeptBean;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Mapper
public interface DeptDao {

   /**
    * 添加部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int addDept(DeptBean dept);

   /**
    * 删除部门
    *
    * @param id 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deleteDept(@Param("id") Long id);

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDept(DeptBean dept);

   /**
    * 更新部门状态
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDeptStatus(DeptBean dept);

   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return Dept
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   DeptBean queryDeptDetail(DeptBean dept);

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return List<Dept>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   List<DeptBean> queryDeptList(DeptBean dept);

   /**
    * 检查部门是否已存在
    *
    * @param deptName 部门名称
    * @param parentId 父id
    * @return int
    * @author 刘飞华
    * @date: 2024/10/8 15:14
    */
   int checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId")int parentId);

   /**
    * 根据id查询部门详情
    *
    * @param deptId 请求参数
    * @return Dept
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   DeptBean queryDeptById(@Param("deptId")int deptId);

   /**
    * 是否存在部门子节点
    *
    * @param deptId 部门ID
    * @return 结果
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int hasChildByDeptId(Long deptId);

   /**
    * 查询部门是否存在用户
    *
    * @param deptId 部门ID
    * @return 结果 true 存在 false 不存在
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int checkDeptExistUser(Long deptId);

   /**
    * 校验部门是否有数据权限
    *
    * @param deptId 部门id
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int checkDeptDataScope(Long deptId);

}
