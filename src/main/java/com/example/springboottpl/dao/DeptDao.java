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
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deleteDept(List<Integer> ids);

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
    * @param deptName 部门名称
    * @param parentId 父id
    * @return int
    * @author 刘飞华
    * @date: 2024/10/8 15:14
    */
   int checkDeptName(@Param("deptName") String deptName, @Param("parentId")int parentId);

   /**
    * 根据id查询部门详情
    *
    * @param deptId 请求参数
    * @return Dept
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   DeptBean queryDeptById(@Param("deptId")int deptId);

}
