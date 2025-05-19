package com.example.tpl.system.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpl.system.biz.DictDataBiz;
import com.example.tpl.system.dao.DictDataDao;
import com.example.tpl.system.entity.DictDataBean;
import com.example.tpl.system.util.Result;
import com.example.tpl.system.util.ResultPage;
import com.example.tpl.system.vo.req.AddDictDataReqVo;
import com.example.tpl.system.vo.req.DeleteDictDataReqVo;
import com.example.tpl.system.vo.req.QueryDictDataDetailReqVo;
import com.example.tpl.system.vo.req.QueryDictDataListReqVo;
import com.example.tpl.system.vo.req.UpdateDictDataReqVo;
import com.example.tpl.system.vo.req.UpdateDictDataStatusReqVo;
import com.example.tpl.system.vo.resp.QueryDictDataDetailRespVo;
import com.example.tpl.system.vo.resp.QueryDictDataListRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:34
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
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> addDictData(AddDictDataReqVo dictData) {
        String dictType = dictData.getDictType();//字典类型
        String dictLabel = dictData.getDictLabel();//字典标签
        String dictValue = dictData.getDictValue();//字典键值

        List<DictDataBean> dictDataByType = dictDataDao.queryDictDataByType(dictType);
        if (dictDataByType.isEmpty()) {
            return Result.error("新增字典数据失败,字典类型不存在");
        }

        DictDataBean dictDataBean = dictDataDao.queryDictDataByLabel(dictType, dictLabel);
        if (dictDataBean != null) {
            return Result.error("新增字典数据失败,字典标签已存在");
        }

        DictDataBean dictDataValue = dictDataDao.queryDictDataByValue(dictType, dictValue);
        if (dictDataValue != null) {
            return Result.error("新增字典数据失败,字典键值已存在");
        }

        DictDataBean bean = new DictDataBean();
        bean.setDictSort(dictData.getDictSort()); //字典排序
        bean.setDictLabel(dictLabel); //字典标签
        bean.setDictValue(dictValue); //字典键值
        bean.setDictType(dictType); //字典类型
        bean.setCssClass(dictData.getCssClass()); //样式属性（其他样式扩展）
        bean.setListClass(dictData.getListClass()); //表格回显样式
        bean.setIsDefault(dictData.getIsDefault()); //是否默认（Y是 N否）
        bean.setStatus(dictData.getStatus()); //状态（0：停用，1:正常）
        bean.setRemark(dictData.getRemark()); //备注

        int i = dictDataDao.addDictData(bean);
        return Result.success(i);
    }

    /**
     * 删除字典数据
     *
     * @param dictData 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> deleteDictData(DeleteDictDataReqVo dictData) {
        int i = dictDataDao.deleteDictData(dictData.getIds());
        return Result.success(i);
    }

    /**
     * 更新字典数据
     *
     * @param dictData 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> updateDictData(UpdateDictDataReqVo dictData) {
        Long dictCode = dictData.getDictCode();//字典编码
        String dictType = dictData.getDictType();//字典类型
        String dictLabel = dictData.getDictLabel();//字典标签
        String dictValue = dictData.getDictValue();//字典键值

        List<DictDataBean> dictDataByType = dictDataDao.queryDictDataByType(dictType);
        if (dictDataByType.isEmpty()) {
            return Result.error("更新字典数据失败,字典类型不存在");
        }

        DictDataBean dictDataById = dictDataDao.queryDictDataById(dictCode);
        if (dictDataById == null) {
            return Result.error("更新字典数据失败,字典数据不存在");
        }

        DictDataBean dictDataBean = dictDataDao.queryDictDataByLabel(dictData.getDictType(), dictData.getDictLabel());
        if (dictDataBean != null && !dictDataBean.getDictCode().equals(dictCode)) {
            return Result.error("更新字典数据失败,字典标签已存在");
        }

        DictDataBean dictDataValue = dictDataDao.queryDictDataByValue(dictData.getDictType(), dictData.getDictLabel());
        if (dictDataValue != null && !dictDataValue.getDictCode().equals(dictCode)) {
            return Result.error("更新字典数据失败,字典键值已存在");
        }

        DictDataBean bean = new DictDataBean();
        bean.setDictCode(dictData.getDictCode());//字典编码
        bean.setDictSort(dictData.getDictSort()); //字典排序
        bean.setDictLabel(dictLabel); //字典标签
        bean.setDictValue(dictValue); //字典键值
        bean.setDictType(dictType); //字典类型
        bean.setCssClass(dictData.getCssClass()); //样式属性（其他样式扩展）
        bean.setListClass(dictData.getListClass()); //表格回显样式
        bean.setIsDefault(dictData.getIsDefault()); //是否默认（Y是 N否）
        bean.setStatus(dictData.getStatus()); //状态（0：停用，1:正常）
        bean.setRemark(dictData.getRemark()); //备注

        int i = dictDataDao.updateDictData(bean);
        return Result.success(i);
    }

    /**
     * 更新字典数据状态
     *
     * @param dictData 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> updateDictDataStatus(UpdateDictDataStatusReqVo dictData) {

        int i = dictDataDao.updateDictDataStatus(dictData);
        return Result.success(i);
    }

    /**
     * 查询字典数据详情
     *
     * @param dictData 请求参数
     * @return DictDataResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<QueryDictDataDetailRespVo> queryDictDataDetail(QueryDictDataDetailReqVo dictData) {

        DictDataBean bean = new DictDataBean();
        bean.setDictCode(dictData.getDictCode());//字典编码
        //bean.setDictSort(dictData.getDictSort());//字典排序
        //bean.setDictLabel(dictData.getDictLabel());//字典标签
        //bean.setDictValue(dictData.getDictValue());//字典键值
        //bean.setDictType(dictData.getDictType());//字典类型
        //bean.setCssClass(dictData.getCssClass());//样式属性（其他样式扩展）
        //bean.setListClass(dictData.getListClass());//表格回显样式
        //bean.setIsDefault(dictData.getIsDefault());//是否默认（Y是 N否）
        //bean.setStatus(dictData.getStatus());//状态（0：停用，1:正常）

        DictDataBean dataBean = dictDataDao.queryDictDataDetail(bean);
        if (dataBean == null) {
            return Result.error("查询字典数据详情失败,字典数据不存在");
        }
        QueryDictDataDetailRespVo resp = new QueryDictDataDetailRespVo();
        resp.setDictCode(dataBean.getDictCode());//字典编码
        resp.setDictSort(dataBean.getDictSort());//字典排序
        resp.setDictLabel(dataBean.getDictLabel());//字典标签
        resp.setDictValue(dataBean.getDictValue());//字典键值
        resp.setDictType(dataBean.getDictType());//字典类型
        resp.setCssClass(dataBean.getCssClass());//样式属性（其他样式扩展）
        resp.setListClass(dataBean.getListClass());//表格回显样式
        resp.setIsDefault(dataBean.getIsDefault());//是否默认（Y是 N否）
        resp.setStatus(dataBean.getStatus());//状态（0：停用，1:正常）
        resp.setRemark(dataBean.getRemark());//备注
        resp.setCreateTime(dataBean.getCreateTime());//创建时间
        resp.setUpdateTime(dataBean.getUpdateTime());//修改时间

        return Result.success(resp);
    }

    /**
     * 查询字典数据列表
     *
     * @param dictData 请求参数
     * @return DictDataResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<ResultPage<QueryDictDataListRespVo>> queryDictDataList(QueryDictDataListReqVo dictData) {
        DictDataBean bean = new DictDataBean();
        bean.setDictLabel(dictData.getDictLabel());//字典标签
        bean.setDictType(dictData.getDictType());//字典类型
        bean.setStatus(dictData.getStatus());//状态（0：停用，1:正常）

        PageHelper.startPage(dictData.getPageNo(), dictData.getPageSize());
        List<DictDataBean> query = dictDataDao.queryDictDataList(bean);
        PageInfo<DictDataBean> pageInfo = new PageInfo<>(query);

        List<DictDataBean> infoList = pageInfo.getList();

        List<QueryDictDataListRespVo> list = new ArrayList<>();

        for (DictDataBean dataBean : infoList) {
            QueryDictDataListRespVo resp = new QueryDictDataListRespVo();
            resp.setDictCode(dataBean.getDictCode());//字典编码
            resp.setDictSort(dataBean.getDictSort());//字典排序
            resp.setDictLabel(dataBean.getDictLabel());//字典标签
            resp.setDictValue(dataBean.getDictValue());//字典键值
            resp.setDictType(dataBean.getDictType());//字典类型
            resp.setCssClass(dataBean.getCssClass());//样式属性（其他样式扩展）
            resp.setListClass(dataBean.getListClass());//表格回显样式
            resp.setIsDefault(dataBean.getIsDefault());//是否默认（Y是 N否）
            resp.setStatus(dataBean.getStatus());//状态（0：停用，1:正常）
            resp.setRemark(dataBean.getRemark());//备注
            resp.setCreateTime(dataBean.getCreateTime());//创建时间
            resp.setUpdateTime(dataBean.getUpdateTime());//修改时间

            list.add(resp);
        }

        return Result.success(new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));

    }
}