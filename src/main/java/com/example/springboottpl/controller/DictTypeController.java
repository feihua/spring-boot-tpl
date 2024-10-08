package com.example.springboottpl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.vo.req.*;
import com.example.springboottpl.vo.resp.*;
import com.example.springboottpl.service.DictTypeService;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Api(tags = "字典类型")
@RestController
@RequestMapping("/dictType")
public class DictTypeController {

   @Autowired
   private DictTypeService dictTypeService;

   /**
    * 添加字典类型
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("添加字典类型")
   @PostMapping("/addDictType")
   @OperateLog(description = "【字典类型】添加字典类型")
   public Integer addDictType(@RequestBody @Valid AddDictTypeReqVo record){
        return dictTypeService.addDictType(record);
   }

   /**
    * 删除字典类型
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("删除字典类型")
   @PostMapping("/deleteDictType")
   @OperateLog(description = "【字典类型】删除字典类型")
   public Integer deleteDictType(@RequestBody @Valid DeleteDictTypeReqVo record){
        return dictTypeService.deleteDictType(record);
   }

   /**
    * 更新字典类型
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("更新字典类型")
   @PostMapping("/updateDictType")
   @OperateLog(description = "【字典类型】更新字典类型")
   public Integer updateDictType(@RequestBody @Valid UpdateDictTypeReqVo record){
        return dictTypeService.updateDictType(record);
   }

   /**
   * 更新字典类型状态
   *
   * @param record 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2024-10-08 14:26:30
   */
  @ApiOperation("更新字典类型状态")
  @PostMapping("/updateDictTypeStatus")
  @OperateLog(description = "【字典类型】更新字典类型状态")
  public Integer updateDictTypeStatus(@RequestBody @Valid UpdateDictTypeStatusReqVo record){
       return dictTypeService.updateDictTypeStatus(record);
  }

   /**
    * 查询字典类型详情
    *
    * @param record 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("查询字典类型详情")
   @PostMapping("/queryDictTypeDetail")
   @OperateLog(description = "【字典类型】查询字典类型详情")
   public QueryDictTypeDetailRespVo queryDictTypeDetail(@RequestBody @Valid QueryDictTypeDetailReqVo record){
       return dictTypeService.queryDictTypeDetail(record);
   }

   /**
    * 查询字典类型列表
    *
    * @param record 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("查询字典类型列表")
   @PostMapping("/queryDictTypeList")
   @OperateLog(description = "【字典类型】查询字典类型列表")
   public QueryDictTypeListRespVo queryDictTypeList(@RequestBody @Valid QueryDictTypeListReqVo record){
        return dictTypeService.queryDictTypeList(record);
   }

}
