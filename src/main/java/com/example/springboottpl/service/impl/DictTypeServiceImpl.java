package com.example.tpl.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.*;
import com.example.tpl.system.vo.resp.*;
import com.example.tpl.system.biz.DictTypeBiz;
import com.example.tpl.system.service.DictTypeService;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
@Service
public class DictTypeServiceImpl implements DictTypeService {

   @Autowired
   private DictTypeBiz dictTypeBiz;

   /**
    * 添加字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> addDictType(AddDictTypeReqVo dictType){

        return dictTypeBiz.addDictType(dictType);
   }

   /**
    * 删除字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> deleteDictType(DeleteDictTypeReqVo dictType){
		return dictTypeBiz.deleteDictType(dictType);
   }

   /**
    * 更新字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<Integer> updateDictType(UpdateDictTypeReqVo dictType){

        return dictTypeBiz.updateDictType(dictType);
   }

   /**
   * 更新字典类型状态
   *
   * @param dictType 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2025/01/13 17:57:36
   */
  @Override
  public Result<Integer> updateDictTypeStatus(UpdateDictTypeStatusReqVo dictType){

       return dictTypeBiz.updateDictTypeStatus(dictType);
  }

   /**
    * 查询字典类型详情
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<QueryDictTypeDetailRespVo> queryDictTypeDetail(QueryDictTypeDetailReqVo dictType){

       return dictTypeBiz.queryDictTypeDetail(dictType);
   }

   /**
    * 查询字典类型列表
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   @Override
   public Result<ResultPage<QueryDictTypeListRespVo>> queryDictTypeList(QueryDictTypeListReqVo dictType){

        return dictTypeBiz.queryDictTypeList(dictType);
   }

}