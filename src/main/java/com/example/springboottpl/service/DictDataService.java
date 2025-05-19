package com.example.springboottpl.service;

import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddDictDataReqVo;
import com.example.springboottpl.vo.req.DeleteDictDataReqVo;
import com.example.springboottpl.vo.req.QueryDictDataDetailReqVo;
import com.example.springboottpl.vo.req.QueryDictDataListReqVo;
import com.example.springboottpl.vo.req.UpdateDictDataReqVo;
import com.example.springboottpl.vo.req.UpdateDictDataStatusReqVo;
import com.example.springboottpl.vo.resp.QueryDictDataDetailRespVo;
import com.example.springboottpl.vo.resp.QueryDictDataListRespVo;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface DictDataService {

   /**
    * 添加字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addDictData(AddDictDataReqVo dictData);

   /**
    * 删除字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteDictData(DeleteDictDataReqVo dictData);

   /**
    * 更新字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateDictData(UpdateDictDataReqVo dictData);

   /**
    * 更新字典数据状态
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateDictDataStatus(UpdateDictDataStatusReqVo dictData);


   /**
    * 查询字典数据详情
    *
    * @param dictData 请求参数
    * @return QueryDictDataDetailResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryDictDataDetailRespVo> queryDictDataDetail(QueryDictDataDetailReqVo dictData);

   /**
    * 查询字典数据列表
    *
    * @param dictData 请求参数
    * @return QueryDictDataListResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<ResultPage<QueryDictDataListRespVo>> queryDictDataList(QueryDictDataListReqVo dictData);

}