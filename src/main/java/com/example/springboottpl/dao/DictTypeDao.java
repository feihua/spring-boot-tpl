package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboottpl.entity.DictTypeBean;
import com.example.springboottpl.vo.req.UpdateDictTypeStatusReqVo;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface DictTypeDao {

    /**
     * 添加字典类型
     *
     * @param dictType 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addDictType(DictTypeBean dictType);

    /**
     * 删除字典类型
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteDictType(List<Long> ids);

    /**
     * 更新字典类型
     *
     * @param dictType 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateDictType(DictTypeBean dictType);

    /**
     * 更新字典类型状态
     *
     * @param dictType 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateDictTypeStatus(UpdateDictTypeStatusReqVo dictType);

    /**
     * 查询字典类型详情
     *
     * @param dictType 请求参数
     * @return DictType
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictTypeBean queryDictTypeDetail(DictTypeBean dictType);

    /**
     * 根据id查询字典类型详情
     *
     * @param id 请求参数
     * @return DictType
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictTypeBean queryDictTypeById(@Param("id") long id);


    /**
     * 根据dictName查询字典类型详情
     *
     * @param dictName 请求参数
     * @return DictType
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictTypeBean queryDictTypeByName(@Param("dictName") String dictName);

    /**
     * 根据dictType查询字典类型详情
     *
     * @param dictType 请求参数
     * @return DictType
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    DictTypeBean queryDictTypeByType(@Param("dictType") String dictType);

    /**
     * 查询字典类型列表
     *
     * @param dictType 请求参数
     * @return List<DictType>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<DictTypeBean> queryDictTypeList(DictTypeBean dictType);

    /**
     * 通过字典类型查询字典类型使用数量
     *
     * @param dictType 请求参数
     * @return List<DictType>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int countDictDataByType(String dictType);
}
