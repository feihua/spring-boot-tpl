package com.example.tpl.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.DeptBiz;
import com.example.tpl.system.service.DeptService;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.vo.req.AddDeptReqVo;
import com.example.tpl.system.vo.req.DeleteDeptReqVo;
import com.example.tpl.system.vo.req.QueryDeptDetailReqVo;
import com.example.tpl.system.vo.req.QueryDeptListReqVo;
import com.example.tpl.system.vo.req.UpdateDeptReqVo;
import com.example.tpl.system.vo.req.UpdateDeptStatusReqVo;
import com.example.tpl.system.vo.resp.QueryDeptDetailRespVo;
import com.example.tpl.system.vo.resp.QueryDeptListRespVo;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
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
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> addDept(AddDeptReqVo dept){

        return deptBiz.addDept(dept);
   }

   /**
    * 删除部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> deleteDept(DeleteDeptReqVo dept){
		return deptBiz.deleteDept(dept);
   }

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> updateDept(UpdateDeptReqVo dept){

        return deptBiz.updateDept(dept);
   }

   /**
   * 更新部门状态
   *
   * @param dept 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2025/01/13 17:57:36
   */
  @Override
  public Result<Integer> updateDeptStatus(UpdateDeptStatusReqVo dept){

       return deptBiz.updateDeptStatus(dept);
  }

   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<QueryDeptDetailRespVo> queryDeptDetail(QueryDeptDetailReqVo dept){

       return deptBiz.queryDeptDetail(dept);
   }

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<List<QueryDeptListRespVo>> queryDeptList(QueryDeptListReqVo dept){

        return deptBiz.queryDeptList(dept);
   }

}