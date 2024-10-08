package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.DeptBiz;
import com.example.springboottpl.service.DeptService;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Service
public class DeptServiceImpl implements DeptService {

   @Autowired
   private DeptBiz deptBiz;

   /**
    * 添加部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int addDept(AddDeptReqVo dept){

        return deptBiz.addDept(dept);
   }

   /**
    * 删除部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int deleteDept(DeleteDeptReqVo dept){
		return deptBiz.deleteDept(dept);
   }

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int updateDept(UpdateDeptReqVo dept){

        return deptBiz.updateDept(dept);
   }

   /**
   * 更新部门状态
   *
   * @param dept 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2024-10-08 14:26:30
   */
  @Override
  public int updateDeptStatus(UpdateDeptStatusReqVo dept){

       return deptBiz.updateDeptStatus(dept);
  }

   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDeptDetailRespVo queryDeptDetail(QueryDeptDetailReqVo dept){

       return deptBiz.queryDeptDetail(dept);
   }

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDeptListRespVo queryDeptList(QueryDeptListReqVo dept){

        return deptBiz.queryDeptList(dept);
   }

}