package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springboottpl.entity.OperationLogBean;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2023-09-22 09:54:29
 */
@Mapper
public interface OperationLogDao {

   /**
    * 添加操作日志
    *
    * @param operationLog 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   int saveOperationLog(OperationLogBean operationLog);

   /**
    * 删除操作日志
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   int deleteOperationLog(List<Integer> ids);


   /**
    * 查询操作日志列表
    *
    * @param operationLog 请求参数
    * @return List<OperationLog>
    * @author 刘飞华
    * @date: 2023-09-22 09:54:29
    */
   List<OperationLogBean> queryOperationLogList(OperationLogBean operationLog);

}
