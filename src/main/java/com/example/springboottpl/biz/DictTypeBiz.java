package com.example.tpl.system.biz;

import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddDictTypeReqVo;
import com.example.tpl.system.vo.req.DeleteDictTypeReqVo;
import com.example.tpl.system.vo.req.QueryDictTypeDetailReqVo;
import com.example.tpl.system.vo.req.QueryDictTypeListReqVo;
import com.example.tpl.system.vo.req.UpdateDictTypeReqVo;
import com.example.tpl.system.vo.req.UpdateDictTypeStatusReqVo;
import com.example.tpl.system.vo.resp.QueryDictTypeDetailRespVo;
import com.example.tpl.system.vo.resp.QueryDictTypeListRespVo;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2025/01/13 17:57:36
 */
public interface DictTypeBiz {

   /**
    * 添加字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> addDictType(AddDictTypeReqVo dictType);

   /**
    * 删除字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> deleteDictType(DeleteDictTypeReqVo dictType);

   /**
    * 更新字典类型
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateDictType(UpdateDictTypeReqVo dictType);

   /**
    * 更新字典类型状态
    *
    * @param dictType 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<Integer> updateDictTypeStatus(UpdateDictTypeStatusReqVo dictType);

   /**
    * 查询字典类型详情
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<QueryDictTypeDetailRespVo> queryDictTypeDetail(QueryDictTypeDetailReqVo dictType);

   /**
    * 查询字典类型列表
    *
    * @param dictType 请求参数
    * @return ResultPage<DictTypeResp>
    * @author 刘飞华
    * @date: 2025/01/13 17:57:36
    */
   Result<ResultPage<QueryDictTypeListRespVo>> queryDictTypeList(QueryDictTypeListReqVo dictType);

}