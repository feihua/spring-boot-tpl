package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.UserBean;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserReqVo;
import com.example.springboottpl.vo.req.UserListReqVo;
import com.example.springboottpl.vo.req.UserAddReqVo;
import com.example.springboottpl.vo.req.UserDeleteReqVo;
import com.example.springboottpl.vo.req.UserUpdateReqVo;
import com.example.springboottpl.vo.resp.UserRespVo;
import com.example.springboottpl.dao.UserDao;
import com.example.springboottpl.biz.UserBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Service
public class UserBizImpl implements UserBiz {

   @Autowired
   private UserDao userDao;

   /**
    * 添加用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int saveUser(UserAddReqVo user){
        UserBean bean = new UserBean();
        bean.setId(user.getId());
        bean.setMobile(user.getMobile());
        bean.setUserName(user.getUserName());
        bean.setPassword(user.getPassword());
        bean.setStatusId(user.getStatusId());
        bean.setSort(user.getSort());
        bean.setRemark(user.getRemark());
        bean.setCreateTime(user.getCreateTime());
        bean.setUpdateTime(user.getUpdateTime());

        return userDao.saveUser(bean);
   }

   /**
    * 删除用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int deleteUser(UserDeleteReqVo user){
		return userDao.deleteUser(user.getIds());
   }

   /**
    * 更新用户信息
    *
    * @param user 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public int updateUser(UserUpdateReqVo user){
        UserBean bean = new UserBean();
        bean.setId(user.getId());
        bean.setMobile(user.getMobile());
        bean.setUserName(user.getUserName());
        bean.setPassword(user.getPassword());
        bean.setStatusId(user.getStatusId());
        bean.setSort(user.getSort());
        bean.setRemark(user.getRemark());
        bean.setCreateTime(user.getCreateTime());
        bean.setUpdateTime(user.getUpdateTime());

        return userDao.updateUser(bean);
   }

   /**
    * 查询用户信息
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public UserRespVo queryUser(UserReqVo user){
        UserBean bean = new UserBean();
        //bean.setId(user.getId());
        //bean.setMobile(user.getMobile());
        //bean.setUserName(user.getUserName());
        //bean.setPassword(user.getPassword());
        //bean.setStatusId(user.getStatusId());
        //bean.setSort(user.getSort());
        //bean.setRemark(user.getRemark());
        //bean.setCreateTime(user.getCreateTime());
        //bean.setUpdateTime(user.getUpdateTime());

        UserBean query = userDao.queryUser(bean);

        return UserRespVo.builder().build();
   }

   /**
    * 查询用户信息列表
    *
    * @param user 请求参数
    * @return UserResp
    * @author 刘飞华
    * @date: 2023-09-20 10:44:26
    */
   @Override
   public ResultPage<UserRespVo> queryUserList(UserListReqVo user){
        UserBean bean = new UserBean();
        //bean.setId(user.getId());
        //bean.setMobile(user.getMobile());
        //bean.setUserName(user.getUserName());
        //bean.setPassword(user.getPassword());
        //bean.setStatusId(user.getStatusId());
        //bean.setSort(user.getSort());
        //bean.setRemark(user.getRemark());
        //bean.setCreateTime(user.getCreateTime());
        //bean.setUpdateTime(user.getUpdateTime());

        PageHelper.startPage(user.getPageNum(), user.getPageSize());
	    List<UserBean> query = userDao.queryUserList(bean);
        PageInfo<UserBean> pageInfo = new PageInfo<>(query);

	    List<UserRespVo> list = pageInfo.getList().stream().map(x -> {
            UserRespVo resp = new UserRespVo();
            resp.setId(x.getId());
            resp.setMobile(x.getMobile());
            resp.setUserName(x.getUserName());
            resp.setPassword(x.getPassword());
            resp.setStatusId(x.getStatusId());
            resp.setSort(x.getSort());
            resp.setRemark(x.getRemark());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateTime(x.getUpdateTime());
		   return resp;
	    }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
}