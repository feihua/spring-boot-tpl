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
import com.example.springboottpl.service.DictDataService;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2024-10-08 14:26:30
 */
@Api(tags = "字典数据")
@RestController
@RequestMapping("/dictData")
public class DictDataController {

   @Autowired
   private DictDataService dictDataService;

   /**
    * 添加字典数据
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("添加字典数据")
   @PostMapping("/addDictData")
   @OperateLog(description = "【字典数据】添加字典数据")
   public Integer addDictData(@RequestBody @Valid AddDictDataReqVo record){
        return dictDataService.addDictData(record);
   }

   /**
    * 删除字典数据
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("删除字典数据")
   @PostMapping("/deleteDictData")
   @OperateLog(description = "【字典数据】删除字典数据")
   public Integer deleteDictData(@RequestBody @Valid DeleteDictDataReqVo record){
        return dictDataService.deleteDictData(record);
   }

   /**
    * 更新字典数据
    *
    * @param record 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("更新字典数据")
   @PostMapping("/updateDictData")
   @OperateLog(description = "【字典数据】更新字典数据")
   public Integer updateDictData(@RequestBody @Valid UpdateDictDataReqVo record){
        return dictDataService.updateDictData(record);
   }

   /**
   * 更新字典数据状态
   *
   * @param record 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2024-10-08 14:26:30
   */
  @ApiOperation("更新字典数据状态")
  @PostMapping("/updateDictDataStatus")
  @OperateLog(description = "【字典数据】更新字典数据状态")
  public Integer updateDictDataStatus(@RequestBody @Valid UpdateDictDataStatusReqVo record){
       return dictDataService.updateDictDataStatus(record);
  }

   /**
    * 查询字典数据详情
    *
    * @param record 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("查询字典数据详情")
   @PostMapping("/queryDictDataDetail")
   @OperateLog(description = "【字典数据】查询字典数据详情")
   public QueryDictDataDetailRespVo queryDictDataDetail(@RequestBody @Valid QueryDictDataDetailReqVo record){
       return dictDataService.queryDictDataDetail(record);
   }

   /**
    * 查询字典数据列表
    *
    * @param record 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2024-10-08 14:26:30
    */
   @ApiOperation("查询字典数据列表")
   @PostMapping("/queryDictDataList")
   @OperateLog(description = "【字典数据】查询字典数据列表")
   public QueryDictDataListRespVo queryDictDataList(@RequestBody @Valid QueryDictDataListReqVo record){
        return dictDataService.queryDictDataList(record);
   }

}
