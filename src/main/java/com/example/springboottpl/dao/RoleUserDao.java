package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.RoleUser;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:28
 */
@Mapper
public interface RoleUserDao {

   /**
    * 查询角色用户关联表
    *
    * @param roleUser 请求参数
    * @return RoleUser
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   RoleUser query(RoleUser roleUser);

   /**
    * 查询角色用户关联表列表
    *
    * @param roleUser 请求参数
    * @return List<RoleUser>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   List<RoleUser> queryRoleUserList(RoleUser roleUser);

   /**
    * 添加角色用户关联表
    *
    * @param roleUser 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   int insert(RoleUser roleUser);

   /**
    * 删除角色用户关联表
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   int delete(List<Integer> ids);

   /**
    * 更新角色用户关联表
    *
    * @param roleUser 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:28
    */
   int update(RoleUser roleUser);

}