package com.example.springboottpl.biz;

import java.util.Map;

import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
public interface DictDataBiz {

   /**
    * 添加字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int addDictData(AddDictDataReqVo dictData);

   /**
    * 删除字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int deleteDictData(DeleteDictDataReqVo dictData);

   /**
    * 更新字典数据
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDictData(UpdateDictDataReqVo dictData);

   /**
    * 更新字典数据状态
    *
    * @param dictData 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   int updateDictDataStatus(UpdateDictDataStatusReqVo dictData);

   /**
    * 查询字典数据详情
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   QueryDictDataDetailRespVo queryDictDataDetail(QueryDictDataDetailReqVo dictData);

   /**
    * 查询字典数据列表
    *
    * @param dictData 请求参数
    * @return ResultPage<DictDataResp>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   QueryDictDataListRespVo queryDictDataList(QueryDictDataListReqVo dictData);

}