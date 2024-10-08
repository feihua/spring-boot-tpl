package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.DictDataBiz;
import com.example.springboottpl.service.DictDataService;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
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
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int addDictData(AddDictDataReqVo dictData){

        return dictDataBiz.addDictData(dictData);
   }

   /**
    * 删除字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int deleteDictData(DeleteDictDataReqVo dictData){
		return dictDataBiz.deleteDictData(dictData);
   }

   /**
    * 更新字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int updateDictData(UpdateDictDataReqVo dictData){

        return dictDataBiz.updateDictData(dictData);
   }

   /**
   * 更新字典数据状态
   *
   * @param dictData 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2024-10-08 14:26:30
   */
  @Override
  public int updateDictDataStatus(UpdateDictDataStatusReqVo dictData){

       return dictDataBiz.updateDictDataStatus(dictData);
  }

   /**
    * 查询字典数据详情
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDictDataDetailRespVo queryDictDataDetail(QueryDictDataDetailReqVo dictData){

       return dictDataBiz.queryDictDataDetail(dictData);
   }

   /**
    * 查询字典数据列表
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDictDataListRespVo queryDictDataList(QueryDictDataListReqVo dictData){

        return dictDataBiz.queryDictDataList(dictData);
   }

}