package com.example.tpl.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.*;
import com.example.tpl.system.vo.resp.*;
import com.example.tpl.system.biz.DictDataBiz;
import com.example.tpl.system.service.DictDataService;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
@Service
public class DictDataServiceImpl implements DictDataService {

   @Autowired
   private DictDataBiz dictDataBiz;

   /**
    * 添加字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> addDictData(AddDictDataReqVo dictData){

        return dictDataBiz.addDictData(dictData);
   }

   /**
    * 删除字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> deleteDictData(DeleteDictDataReqVo dictData){
		return dictDataBiz.deleteDictData(dictData);
   }

   /**
    * 更新字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> updateDictData(UpdateDictDataReqVo dictData){

        return dictDataBiz.updateDictData(dictData);
   }

   /**
   * 更新字典数据状态
   *
   * @param dictData 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2025/01/13 17:57:36
   */
  @Override
  public Result<Integer> updateDictDataStatus(UpdateDictDataStatusReqVo dictData){

       return dictDataBiz.updateDictDataStatus(dictData);
  }

   /**
    * 查询字典数据详情
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<QueryDictDataDetailRespVo> queryDictDataDetail(QueryDictDataDetailReqVo dictData){

       return dictDataBiz.queryDictDataDetail(dictData);
   }

   /**
    * 查询字典数据列表
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<ResultPage<QueryDictDataListRespVo>> queryDictDataList(QueryDictDataListReqVo dictData){

        return dictDataBiz.queryDictDataList(dictData);
   }

}