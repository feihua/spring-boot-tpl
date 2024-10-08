package com.example.springboottpl.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.example.springboottpl.entity.DictDataBean;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Mapper
public interface DictDataDao {

   /**
    * 添加字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int addDictData(DictDataBean dictData);

   /**
    * 删除字典数据
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deleteDictData(List<Integer> ids);

   /**
    * 更新字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDictData(DictDataBean dictData);

      /**
       * 更新字典数据状态
       *
       * @param dictData 请求参数
       * @return int
       * @author 刘飞华
       * @date: 2024-10-08 14:26:30
       */
      int updateDictDataStatus(DictDataBean dictData);

   /**
    * 查询字典数据详情
    *
    * @param dictData 请求参数
    * @return DictData
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   DictDataBean queryDictDataDetail(DictDataBean dictData);

   /**
    * 查询字典数据列表
    *
    * @param dictData 请求参数
    * @return List<DictData>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   List<DictDataBean> queryDictDataList(DictDataBean dictData);

}
