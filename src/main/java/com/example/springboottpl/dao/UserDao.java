package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.entity.RoleBean;
import com.example.springboottpl.entity.UserBean;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:25
 */
@Mapper
public interface UserDao {

   /**
    * 添加用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int saveUser(UserBean user);

   /**
    * 删除用户信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int deleteUser(List<Integer> ids);

   /**
    * 更新用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   int updateUser(UserBean user);

   /**
    * 查询用户信息
    *
    * @param user 请求参数
    * @return User
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   UserBean queryUser(UserBean user);

   /**
    * 查询用户信息列表
    *
    * @param user 请求参数
    * @return List<User>
    * @author 刘飞华
    * @date: 2023-09-20 10:44:25
    */
   List<UserBean> queryUserList(UserBean user);

   /**
    * 查询用户菜单
    *
    * @param userId 用户id
    * @return List<SysMenu>
    * @author 刘飞华
    * @date: 2023/9/20 14:14
    */
   List<MenuBean> queryUserMenus(int userId);

   /**
    * 查询用户角色
    *
    * @param userId 用户id
    * @return List<SysMenu>
    * @author 刘飞华
    * @date: 2023/3/29 18:10
    */
   List<RoleBean> queryUserRoles(Integer userId);
}
