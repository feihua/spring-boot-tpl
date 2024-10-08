package com.example.springboottpl.biz.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.DictTypeBean;
import com.example.springboottpl.vo.req.*;

import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.dao.DictTypeDao;
import com.example.springboottpl.biz.DictTypeBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Service
public class DictTypeBizImpl implements DictTypeBiz {

   @Autowired
   private DictTypeDao dictTypeDao;

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
        DictTypeBean bean = new DictTypeBean();
        bean.setTenantId(dictType.getTenantId());
        bean.setDictName(dictType.getDictName());
        bean.setDictType(dictType.getDictType());
        bean.setRemark(dictType.getRemark());

        return dictTypeDao.addDictType(bean);
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
		return dictTypeDao.deleteDictType(dictType.getIds());
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
        DictTypeBean bean = new DictTypeBean();
        bean.setDictId(dictType.getDictId());
        bean.setTenantId(dictType.getTenantId());
        bean.setDictName(dictType.getDictName());
        bean.setDictType(dictType.getDictType());
        bean.setRemark(dictType.getRemark());
        return dictTypeDao.updateDictType(bean);
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
        DictTypeBean bean = new DictTypeBean();
        //bean.setDictId(dictType.getDictId());
        //bean.setTenantId(dictType.getTenantId());
        //bean.setDictName(dictType.getDictName());
        //bean.setDictType(dictType.getDictType());

        return dictTypeDao.updateDictTypeStatus(bean);
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
        DictTypeBean bean = new DictTypeBean();
        bean.setDictId(dictType.getDictId());
        //bean.setTenantId(dictType.getTenantId());
        //bean.setDictName(dictType.getDictName());
        //bean.setDictType(dictType.getDictType());

        DictTypeBean query = dictTypeDao.queryDictTypeDetail(bean);

        return QueryDictTypeDetailRespVo.builder().build();
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
        DictTypeBean bean = new DictTypeBean();
        //bean.setTenantId(dictType.getTenantId());
        //bean.setDictName(dictType.getDictName());
        //bean.setDictType(dictType.getDictType());

        PageHelper.startPage(dictType.getPageNum(), dictType.getPageSize());
	    List<DictTypeBean> query = dictTypeDao.queryDictTypeList(bean);
        PageInfo<DictTypeBean> pageInfo = new PageInfo<>(query);

	    List<QueryDictTypeListRespVo> list = pageInfo.getList().stream().map(x -> {
            QueryDictTypeListRespVo resp = new QueryDictTypeListRespVo();
            resp.setDictId(x.getDictId());
            resp.setTenantId(x.getTenantId());
            resp.setDictName(x.getDictName());
            resp.setDictType(x.getDictType());
            resp.setRemark(x.getRemark());
            resp.setCreateDept(x.getCreateDept());
            resp.setCreateBy(x.getCreateBy());
            resp.setCreateTime(x.getCreateTime());
            resp.setUpdateBy(x.getUpdateBy());
            resp.setUpdateTime(x.getUpdateTime());
		   return resp;
	    }).collect(Collectors.toList());

        //return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
        return null;

   }
}