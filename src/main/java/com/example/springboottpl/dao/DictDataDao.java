package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboottpl.entity.DictDataBean;
import com.example.springboottpl.vo.req.UpdateDictDataStatusReqVo;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface DictDataDao {

    /**
     * 添加字典数据
     *
     * @param dictData 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addDictData(DictDataBean dictData);

    /**
     * 删除字典数据
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteDictData(List<Integer> ids);

    /**
     * 更新字典数据
     *
     * @param dictData 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateDictData(DictDataBean dictData);

    /**
     * 更新字典数据状态
     *
     * @param dictData 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateDictDataStatus(UpdateDictDataStatusReqVo dictData);

    /**
     * 查询字典数据详情
     *
     * @param dictData 请求参数
     * @return DictData
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictDataBean queryDictDataDetail(DictDataBean dictData);

    /**
     * 根据id查询字典数据
     *
     * @param id 请求参数
     * @return DictData
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictDataBean queryDictDataById(long id);


    /**
     * 根据dictLabel查询字典数据
     *
     * @param dictLabel 请求参数
     * @return DictData
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictDataBean queryDictDataByLabel(@Param("dictType") String dictType, @Param("dictLabel") String dictLabel);


    /**
     * 根据dictValue查询字典数据
     *
     * @param dictValue 请求参数
     * @return DictData
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictDataBean queryDictDataByValue(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * 根据dictType查询字典数据
     *
     * @param dictType 请求参数
     * @return DictData
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<DictDataBean> queryDictDataByType(@Param("dictType") String dictType);


    /**
     * 查询字典数据列表
     *
     * @param dictData 请求参数
     * @return List<DictData>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<DictDataBean> queryDictDataList(DictDataBean dictData);

}
