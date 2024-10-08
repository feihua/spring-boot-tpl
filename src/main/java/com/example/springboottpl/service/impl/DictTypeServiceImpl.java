package com.example.springboottpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.biz.DictTypeBiz;
import com.example.springboottpl.service.DictTypeService;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
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
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int addDictType(AddDictTypeReqVo dictType){

        return dictTypeBiz.addDictType(dictType);
   }

   /**
    * 删除字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int deleteDictType(DeleteDictTypeReqVo dictType){
		return dictTypeBiz.deleteDictType(dictType);
   }

   /**
    * 更新字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public int updateDictType(UpdateDictTypeReqVo dictType){

        return dictTypeBiz.updateDictType(dictType);
   }

   /**
   * 更新字典类型状态
   *
   * @param dictType 请求参数
   * @return int
   * @author 刘飞华
   * @date: 2024-10-08 14:26:30
   */
  @Override
  public int updateDictTypeStatus(UpdateDictTypeStatusReqVo dictType){

       return dictTypeBiz.updateDictTypeStatus(dictType);
  }

   /**
    * 查询字典类型详情
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDictTypeDetailRespVo queryDictTypeDetail(QueryDictTypeDetailReqVo dictType){

       return dictTypeBiz.queryDictTypeDetail(dictType);
   }

   /**
    * 查询字典类型列表
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @Override
   public QueryDictTypeListRespVo queryDictTypeList(QueryDictTypeListReqVo dictType){

        return dictTypeBiz.queryDictTypeList(dictType);
   }

}