package com.example.tpl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.tpl.system.entity.OperationLogBean;

/**
 * 描述：操作日志
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface OperationLogDao {

    /**
     * 添加操作日志
     *
     * @param operationLog 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addOperationLog(OperationLogBean operationLog);

    /**
     * 删除操作日志
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteOperationLog(List<Integer> ids);

    /**
     * 清空操作日志
     *
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int cleanOperationLog();

    /**
     * 查询操作日志详情
     *
     * @param operationLog 请求参数
     * @return OperationLog
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    OperationLogBean queryOperationLogDetail(OperationLogBean operationLog);

    /**
     * 查询操作日志列表
     *
     * @param operationLog 请求参数
     * @return List<OperationLog>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<OperationLogBean> queryOperationLogList(OperationLogBean operationLog);

}
