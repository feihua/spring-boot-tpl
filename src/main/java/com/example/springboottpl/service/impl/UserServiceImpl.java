package com.example.springboottpl.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.User;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserReq;
import com.example.springboottpl.vo.req.UserListReq;
import com.example.springboottpl.vo.req.UserAddReq;
import com.example.springboottpl.vo.req.UserUpdateReq;
import com.example.springboottpl.vo.resp.UserResp;
import com.example.springboottpl.dao.UserDao;
import com.example.springboottpl.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：后台用户信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:26
 */
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;
   /**
    * 查询后台用户信息
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @Override
   public UserResp query(UserReq user){

       User query = userDao.query(User.builder().build());

       return UserResp.builder().build();
   }
   /**
    * 查询后台用户信息列表
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @Override
   public ResultPage<UserResp> queryUserList(UserListReq user){

       PageHelper.startPage(user.getCurrent(), user.getPageSize());
	   List<User> query = userDao.queryUserList(User.builder().build());
       PageInfo<User> pageInfo = new PageInfo<>(query);

	   List<UserResp> list = pageInfo.getList().stream().map(x -> {
		   UserResp resp = new UserResp();
		   BeanUtils.copyProperties(x, resp);
		   return resp;
	   }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
   /**
    * 添加后台用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @Override
   public int insert(UserAddReq user){

        return userDao.insert(User.builder().build());
   }
   /**
    * 删除后台用户信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @Override
   public int delete(String ids){
		return userDao.delete(Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
   }
   /**
    * 更新后台用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:26
    */
   @Override
   public int update(UserUpdateReq user){

        return userDao.update(User.builder().build());
   }

}