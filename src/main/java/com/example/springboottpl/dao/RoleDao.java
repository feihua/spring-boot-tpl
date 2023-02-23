package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.Role;

/**
 * 描述：角色信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:29
 */
@Mapper
public interface RoleDao {

   /**
    * 查询角色信息
    *
    * @param role 请求参数
    * @return Role
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   Role query(Role role);

   /**
    * 查询角色信息列表
    *
    * @param role 请求参数
    * @return List<Role>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   List<Role> queryRoleList(Role role);

   /**
    * 添加角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   int insert(Role role);

   /**
    * 删除角色信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   int delete(List<Integer> ids);

   /**
    * 更新角色信息
    *
    * @param role 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:29
    */
   int update(Role role);

}