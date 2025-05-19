package com.example.tpl.system.biz;

import java.util.List;

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
public interface DeptBiz {

   /**
    * 添加部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addDept(AddDeptReqVo dept);

   /**
    * 删除部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteDept(DeleteDeptReqVo dept);

   /**
    * 更新部门
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateDept(UpdateDeptReqVo dept);

   /**
    * 更新部门状态
    *
    * @param dept 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateDeptStatus(UpdateDeptStatusReqVo dept);

   /**
    * 查询部门详情
    *
    * @param dept 请求参数
    * @return DeptResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryDeptDetailRespVo> queryDeptDetail(QueryDeptDetailReqVo dept);

   /**
    * 查询部门列表
    *
    * @param dept 请求参数
    * @return ResultPage<DeptResp>
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<List<QueryDeptListRespVo>> queryDeptList(QueryDeptListReqVo dept);

}