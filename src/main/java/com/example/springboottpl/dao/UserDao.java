package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.User;

/**
 * 描述：后台用户信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:26
 */
@Mapper
public interface UserDao {

   /**
    * 查询后台用户信息
    *
    * @param user 请求参数
    * @return User
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   User query(User user);

   /**
    * 查询后台用户信息列表
    *
    * @param user 请求参数
    * @return List<User>
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   List<User> queryUserList(User user);

   /**
    * 添加后台用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   int insert(User user);

   /**
    * 删除后台用户信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   int delete(List<Integer> ids);

   /**
    * 更新后台用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   int update(User user);

}