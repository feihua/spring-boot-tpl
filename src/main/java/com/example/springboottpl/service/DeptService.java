package com.example.springboottpl.service;

import java.util.Map;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
public interface DeptService {

   /**
    * 添加部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int addDept(AddDeptReqVo dept);

   /**
    * 删除部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deleteDept(DeleteDeptReqVo dept);

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDept(UpdateDeptReqVo dept);

   /**
    * 更新部门状态
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDeptStatus(UpdateDeptStatusReqVo dept);


   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return QueryDeptDetailResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   QueryDeptDetailRespVo queryDeptDetail(QueryDeptDetailReqVo dept);

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return QueryDeptListResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   QueryDeptListRespVo queryDeptList(QueryDeptListReqVo dept);

}