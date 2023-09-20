package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.UserRoleBean;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Mapper
public interface UserRoleDao {

   /**
    * 添加角色用户关联表
    *
    * @param userRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int saveUserRole(UserRoleBean userRole);

   /**
    * 删除角色用户关联表
    *
    * @param userId 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int deleteUserRole(Integer userId);

   /**
    * 更新角色用户关联表
    *
    * @param userRole 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   int updateUserRole(UserRoleBean userRole);

   /**
    * 查询角色用户关联表
    *
    * @param userRole 请求参数
    * @return UserRole
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   UserRoleBean queryUserRole(UserRoleBean userRole);

   /**
    * 查询角色用户关联表列表
    *
    * @param userRole 请求参数
    * @return List<UserRole>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   List<UserRoleBean> queryUserRoleList(UserRoleBean userRole);

}
