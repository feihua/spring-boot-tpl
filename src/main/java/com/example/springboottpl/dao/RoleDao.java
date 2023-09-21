package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.RoleBean;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Mapper
public interface RoleDao {

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int saveRole(RoleBean role);

   /**
    * 删除角色信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int deleteRole(List<Integer> ids);

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int updateRole(RoleBean role);

   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return Role
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   RoleBean queryRole(RoleBean role);

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return List<Role>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   List<RoleBean> queryRoleList(RoleBean role);

}
