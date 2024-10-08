package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.DictTypeBean;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Mapper
public interface DictTypeDao {

   /**
    * 添加字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int addDictType(DictTypeBean dictType);

   /**
    * 删除字典类型
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deleteDictType(List<Integer> ids);

   /**
    * 更新字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDictType(DictTypeBean dictType);

      /**
       * 更新字典类型状态
       *
       * @param dictType 请求参数
       * @return int
       * @author 刘飞华
       * @date: 2024-10-08 14:26:30
       */
      int updateDictTypeStatus(DictTypeBean dictType);

   /**
    * 查询字典类型详情
    *
    * @param dictType 请求参数
    * @return DictType
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   DictTypeBean queryDictTypeDetail(DictTypeBean dictType);

   /**
    * 查询字典类型列表
    *
    * @param dictType 请求参数
    * @return List<DictType>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   List<DictTypeBean> queryDictTypeList(DictTypeBean dictType);

}
