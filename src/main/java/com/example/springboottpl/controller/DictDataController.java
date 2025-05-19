package com.example.tpl.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.tpl.system.annotation.OperateLog;
import com.example.tpl.system.service.DictDataService;
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
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：字典数据
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:34
 */
@Tag(name = "5.字典数据")
@RestController
@RequestMapping("/dictData")
public class DictDataController {

   @Autowired
   private DictDataService dictDataService;

   /**
    * 添加字典数据
    *
    * @param dictData 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 1)
   @Operation(summary = "1.1 添加字典数据")
   @PostMapping("/addDictData")
   @OperateLog(description = "【字典数据】添加字典数据")
   public Result<Integer> addDictData(@RequestBody @Valid AddDictDataReqVo dictData){
        return dictDataService.addDictData(dictData);
   }

   /**
    * 删除字典数据
    *
    * @param dictData 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 2)
   @Operation(summary = "1.2 删除字典数据")
   @PostMapping("/deleteDictData")
   @OperateLog(description = "【字典数据】删除字典数据")
   public Result<Integer> deleteDictData(@RequestBody @Valid DeleteDictDataReqVo dictData){
        return dictDataService.deleteDictData(dictData);
   }

   /**
    * 更新字典数据
    *
    * @param dictData 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 3)
   @Operation(summary = "1.3 更新字典数据")
   @PostMapping("/updateDictData")
   @OperateLog(description = "【字典数据】更新字典数据")
   public Result<Integer> updateDictData(@RequestBody @Valid UpdateDictDataReqVo dictData){
        return dictDataService.updateDictData(dictData);
   }

   /**
   * 更新字典数据状态
   *
   * @param dictData 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 4)
   @Operation(summary = "1.4 更新字典数据状态")
   @PostMapping("/updateDictDataStatus")
   @OperateLog(description = "【字典数据】更新字典数据状态")
  public Result<Integer> updateDictDataStatus(@RequestBody @Valid UpdateDictDataStatusReqVo dictData){
       return dictDataService.updateDictDataStatus(dictData);
  }

   /**
    * 查询字典数据详情
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 5)
   @Operation(summary = "1.5 查询字典数据详情")
   @PostMapping("/queryDictDataDetail")
   @OperateLog(description = "【字典数据】查询字典数据详情")
   public Result<QueryDictDataDetailRespVo> queryDictDataDetail(@RequestBody @Valid QueryDictDataDetailReqVo dictData){
       return dictDataService.queryDictDataDetail(dictData);
   }

   /**
    * 查询字典数据列表
    *
    * @param dictData 请求参数
    * @return DictDataResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:34
    */
   @ApiOperationSupport(order = 6)
   @Operation(summary = "1.6 查询字典数据列表")
   @PostMapping("/queryDictDataList")
   @OperateLog(description = "【字典数据】查询字典数据列表")
   public Result<ResultPage<QueryDictDataListRespVo>> queryDictDataList(@RequestBody @Valid QueryDictDataListReqVo dictData){
        return dictDataService.queryDictDataList(dictData);
   }

}
