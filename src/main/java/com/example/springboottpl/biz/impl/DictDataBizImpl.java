package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.DictDataBean;
import com.example.springboottpl.vo.req.*;

import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.dao.DictDataDao;
import com.example.springboottpl.biz.DictDataBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Service
public class DictDataBizImpl implements DictDataBiz {

   @Autowired
   private DictDataDao dictDataDao;

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
        DictDataBean bean = new DictDataBean();
        bean.setTenantId(dictData.getTenantId());
        bean.setDictSort(dictData.getDictSort());
        bean.setDictLabel(dictData.getDictLabel());
        bean.setDictValue(dictData.getDictValue());
        bean.setDictType(dictData.getDictType());
        bean.setCssClass(dictData.getCssClass());
        bean.setListClass(dictData.getListClass());
        bean.setIsDefault(dictData.getIsDefault());
        bean.setRemark(dictData.getRemark());

        return dictDataDao.addDictData(bean);
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
		return dictDataDao.deleteDictData(dictData.getIds());
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
        DictDataBean bean = new DictDataBean();
        bean.setDictCode(dictData.getDictCode());
        bean.setTenantId(dictData.getTenantId());
        bean.setDictSort(dictData.getDictSort());
        bean.setDictLabel(dictData.getDictLabel());
        bean.setDictValue(dictData.getDictValue());
        bean.setDictType(dictData.getDictType());
        bean.setCssClass(dictData.getCssClass());
        bean.setListClass(dictData.getListClass());
        bean.setIsDefault(dictData.getIsDefault());
        bean.setRemark(dictData.getRemark());
        return dictDataDao.updateDictData(bean);
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
        DictDataBean bean = new DictDataBean();
        //bean.setDictCode(dictData.getDictCode());
        //bean.setTenantId(dictData.getTenantId());
        //bean.setDictSort(dictData.getDictSort());
        //bean.setDictLabel(dictData.getDictLabel());
        //bean.setDictValue(dictData.getDictValue());
        //bean.setDictType(dictData.getDictType());
        //bean.setCssClass(dictData.getCssClass());
        //bean.setListClass(dictData.getListClass());
        //bean.setIsDefault(dictData.getIsDefault());

        return dictDataDao.updateDictDataStatus(bean);
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
        DictDataBean bean = new DictDataBean();
        bean.setDictCode(dictData.getDictCode());
        //bean.setTenantId(dictData.getTenantId());
        //bean.setDictSort(dictData.getDictSort());
        //bean.setDictLabel(dictData.getDictLabel());
        //bean.setDictValue(dictData.getDictValue());
        //bean.setDictType(dictData.getDictType());
        //bean.setCssClass(dictData.getCssClass());
        //bean.setListClass(dictData.getListClass());
        //bean.setIsDefault(dictData.getIsDefault());

        DictDataBean query = dictDataDao.queryDictDataDetail(bean);

        return QueryDictDataDetailRespVo.builder().build();
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
        DictDataBean bean = new DictDataBean();
        //bean.setTenantId(dictData.getTenantId());
        //bean.setDictSort(dictData.getDictSort());
        //bean.setDictLabel(dictData.getDictLabel());
        //bean.setDictValue(dictData.getDictValue());
        //bean.setDictType(dictData.getDictType());
        //bean.setCssClass(dictData.getCssClass());
        //bean.setListClass(dictData.getListClass());
        //bean.setIsDefault(dictData.getIsDefault());

        PageHelper.startPage(dictData.getPageNum(), dictData.getPageSize());
	    List<DictDataBean> query = dictDataDao.queryDictDataList(bean);
        PageInfo<DictDataBean> pageInfo = new PageInfo<>(query);

	    List<QueryDictDataListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryDictDataListRespVo resp = new QueryDictDataListRespVo();
            resp.setDictCode(x.getDictCode());
            resp.setTenantId(x.getTenantId());
            resp.setDictSort(x.getDictSort());
            resp.setDictLabel(x.getDictLabel());
            resp.setDictValue(x.getDictValue());
            resp.setDictType(x.getDictType());
            resp.setCssClass(x.getCssClass());
            resp.setListClass(x.getListClass());
            resp.setIsDefault(x.getIsDefault());
            resp.setCreateDept(x.getCreateDept());
            resp.setCreateBy(x.getCreateBy());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateBy(x.getUpdateBy());
            resp.setUpdateTime(x.getUpdateTime());
            resp.setRemark(x.getRemark());
		   return resp;
	    }).collect(Collectors.toList());

        //return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
        return null;

   }
}