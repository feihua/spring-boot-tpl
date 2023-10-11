package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.LoginLogBean;

/**
 * 描述：登录日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:59:01
 */
@Mapper
public interface LoginLogDao {

   /**
    * 添加登录日志
    *
    * @param loginLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   int saveLoginLog(LoginLogBean loginLog);

   /**
    * 删除登录日志
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   int deleteLoginLog(List<Integer> ids);


   /**
    * 查询登录日志列表
    *
    * @param loginLog 请求参数
    * @return List<LoginLog>
    * @author 刘飞华
    * @date: 2023-09-22 09:59:01
    */
   List<LoginLogBean> queryLoginLogList(LoginLogBean loginLog);

}
