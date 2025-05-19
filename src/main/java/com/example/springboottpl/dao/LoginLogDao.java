package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.LoginLogBean;

/**
 * 描述：系统访问记录
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface LoginLogDao {

    /**
     * 添加系统访问记录
     *
     * @param loginLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addLoginLog(LoginLogBean loginLog);

    /**
     * 删除系统访问记录
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteLoginLog(List<Integer> ids);

   /**
    * 清空系统访问记录
    *
    * @return int
    * @author 刘飞华
    * @date: 2025-01-10 14:58:36
    */
   int cleanLoginLog();

    /**
     * 查询系统访问记录详情
     *
     * @param loginLog 请求参数
     * @return LoginLog
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    LoginLogBean queryLoginLogDetail(LoginLogBean loginLog);

    /**
     * 查询系统访问记录列表
     *
     * @param loginLog 请求参数
     * @return List<LoginLog>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<LoginLogBean> queryLoginLogList(LoginLogBean loginLog);

}
