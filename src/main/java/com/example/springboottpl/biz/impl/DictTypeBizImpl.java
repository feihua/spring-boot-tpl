package com.example.springboottpl.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.DictTypeBiz;
import com.example.springboottpl.dao.DictTypeDao;
import com.example.springboottpl.entity.DictTypeBean;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.AddDictTypeReqVo;
import com.example.springboottpl.vo.req.DeleteDictTypeReqVo;
import com.example.springboottpl.vo.req.QueryDictTypeDetailReqVo;
import com.example.springboottpl.vo.req.QueryDictTypeListReqVo;
import com.example.springboottpl.vo.req.UpdateDictTypeReqVo;
import com.example.springboottpl.vo.req.UpdateDictTypeStatusReqVo;
import com.example.springboottpl.vo.resp.QueryDictTypeDetailRespVo;
import com.example.springboottpl.vo.resp.QueryDictTypeListRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:35
 */
@Service
public class DictTypeBizImpl implements DictTypeBiz {

    @Autowired
    private DictTypeDao dictTypeDao;

    /**
     * 添加字典类型
     *
     * @param dict 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> addDictType(AddDictTypeReqVo dict) {
        String dictName = dict.getDictName();//字典名称
        String dictType = dict.getDictType();//字典类型

        DictTypeBean queryByName = dictTypeDao.queryDictTypeByName(dictName);
        if (queryByName != null) {
            return Result.error("添加字典类型失败,字典名称已存在");
        }


        DictTypeBean queryByType = dictTypeDao.queryDictTypeByType(dictType);
        if (queryByType != null) {
            return Result.error("添加字典类型失败,字典类型已存在");
        }

        DictTypeBean bean = new DictTypeBean();
        bean.setDictName(dictName); //字典名称
        bean.setDictType(dictType); //字典类型
        bean.setStatus(dict.getStatus()); //状态（0：停用，1:正常）
        bean.setRemark(dict.getRemark()); //备注
        int i = dictTypeDao.addDictType(bean);
        return Result.success(i);
    }

    /**
     * 删除字典类型
     *
     * @param dictType 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> deleteDictType(DeleteDictTypeReqVo dictType) {
        List<Long> ids = dictType.getIds();
        for (Long id : ids) {
            DictTypeBean dictTypeBean = dictTypeDao.queryDictTypeById(id);
            if (dictTypeBean == null) {
                return Result.error("删除字典类型失败,字典类型不存在");
            }

            int count = dictTypeDao.countDictDataByType(dictTypeBean.getDictType());
            if (count > 0) {
                return Result.error("删除字典类型失败,已分配,不能删除");
            }
        }

        int i = dictTypeDao.deleteDictType(dictType.getIds());
        return Result.success(i);
    }

    /**
     * 更新字典类型
     *
     * @param dict 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> updateDictType(UpdateDictTypeReqVo dict) {
        String dictName = dict.getDictName();//字典名称
        String dictType = dict.getDictType();//字典类型

        DictTypeBean queryById = dictTypeDao.queryDictTypeById(dict.getDictId());
        if (queryById == null) {
            return Result.error("更新字典类型失败,字典类型不存在");
        }
        DictTypeBean queryByName = dictTypeDao.queryDictTypeByName(dictName);
        if (queryByName != null && !queryByName.getDictId().equals(dict.getDictId())) {
            return Result.error("更新字典类型失败,字典名称已存在");
        }

        DictTypeBean queryByType = dictTypeDao.queryDictTypeByType(dictType);
        if (queryByType != null && !queryByType.getDictId().equals(dict.getDictId())) {
            return Result.error("更新字典类型失败,字典类型已存在");
        }

        DictTypeBean bean = new DictTypeBean();
        bean.setDictId(dict.getDictId());//字典主键
        bean.setDictName(dictName);//字典名称
        bean.setDictType(dictType);//字典类型
        bean.setStatus(dict.getStatus());//状态（0：停用，1:正常）
        bean.setRemark(dict.getRemark());//备注

        int i = dictTypeDao.updateDictType(bean);
        return Result.success(i);
    }

    /**
     * 更新字典类型状态
     *
     * @param dictType 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<Integer> updateDictTypeStatus(UpdateDictTypeStatusReqVo dictType) {

        int i = dictTypeDao.updateDictTypeStatus(dictType);
        return Result.success(i);
    }

    /**
     * 查询字典类型详情
     *
     * @param dictType 请求参数
     * @return DictTypeResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<QueryDictTypeDetailRespVo> queryDictTypeDetail(QueryDictTypeDetailReqVo dictType) {
        DictTypeBean bean = new DictTypeBean();
        bean.setDictId(dictType.getId());//字典主键
        //bean.setDictName(dictType.getDictName());//字典名称
        //bean.setDictType(dictType.getDictType());//字典类型
        //bean.setStatus(dictType.getStatus());//状态（0：停用，1:正常）


        DictTypeBean query = dictTypeDao.queryDictTypeDetail(bean);
        if (query == null) {
            return Result.error("查询字典类型详情失败,字典类型不存在");
        }

        QueryDictTypeDetailRespVo resp = new QueryDictTypeDetailRespVo();
        resp.setDictId(query.getDictId());//字典主键
        resp.setDictName(query.getDictName());//字典名称
        resp.setDictType(query.getDictType());//字典类型
        resp.setStatus(query.getStatus());//状态（0：停用，1:正常）
        resp.setRemark(query.getRemark());//备注
        resp.setCreateTime(query.getCreateTime());//创建时间
        resp.setUpdateTime(query.getUpdateTime());//修改时间

        return Result.success(resp);
    }

    /**
     * 查询字典类型列表
     *
     * @param dictType 请求参数
     * @return DictTypeResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:35
     */
    @Override
    public Result<ResultPage<QueryDictTypeListRespVo>> queryDictTypeList(QueryDictTypeListReqVo dictType) {
        DictTypeBean bean = new DictTypeBean();
        bean.setDictName(dictType.getDictName());//字典名称
        bean.setDictType(dictType.getDictType());//字典类型
        bean.setStatus(dictType.getStatus());//状态（0：停用，1:正常）

        PageHelper.startPage(dictType.getPageNo(), dictType.getPageSize());
        List<DictTypeBean> query = dictTypeDao.queryDictTypeList(bean);
        PageInfo<DictTypeBean> pageInfo = new PageInfo<>(query);

        List<DictTypeBean> infoList = pageInfo.getList();
        List<QueryDictTypeListRespVo> list = new ArrayList<>();

        for (DictTypeBean typeBean : infoList) {
            QueryDictTypeListRespVo resp = new QueryDictTypeListRespVo();
            resp.setDictId(typeBean.getDictId());//字典主键
            resp.setDictName(typeBean.getDictName());//字典名称
            resp.setDictType(typeBean.getDictType());//字典类型
            resp.setStatus(typeBean.getStatus());//状态（0：停用，1:正常）
            resp.setRemark(typeBean.getRemark());//备注
            resp.setCreateTime(typeBean.getCreateTime());//创建时间
            resp.setUpdateTime(typeBean.getUpdateTime());//修改时间

            list.add(resp);
        }

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));

    }
}