package com.example.springboottpl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.springboottpl.annotation.OperateLog;
import com.example.springboottpl.service.DictTypeService;
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
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 描述：字典类型
 * 作者：刘飞华
 * 日期：2025/01/15 15:09:35
 */
@Tag(name = "6.字典类型")
@RestController
@RequestMapping("/dictType")
public class DictTypeController {

   @Autowired
   private DictTypeService dictTypeService;

   /**
    * 添加字典类型
    *
    * @param dictType 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 1)
   @Operation(summary = "1.1 添加字典类型")
   @PostMapping("/addDictType")
   @OperateLog(description = "【字典类型】添加字典类型")
   public Result<Integer> addDictType(@RequestBody @Valid AddDictTypeReqVo dictType){
        return dictTypeService.addDictType(dictType);
   }

   /**
    * 删除字典类型
    *
    * @param dictType 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 2)
   @Operation(summary = "1.2 删除字典类型")
   @PostMapping("/deleteDictType")
   @OperateLog(description = "【字典类型】删除字典类型")
   public Result<Integer> deleteDictType(@RequestBody @Valid DeleteDictTypeReqVo dictType){
        return dictTypeService.deleteDictType(dictType);
   }

   /**
    * 更新字典类型
    *
    * @param dictType 请求参数
    * @return Result<Integer>
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 3)
   @Operation(summary = "1.3 更新字典类型")
   @PostMapping("/updateDictType")
   @OperateLog(description = "【字典类型】更新字典类型")
   public Result<Integer> updateDictType(@RequestBody @Valid UpdateDictTypeReqVo dictType){
        return dictTypeService.updateDictType(dictType);
   }

   /**
   * 更新字典类型状态
   *
   * @param dictType 请求参数
   * @return Result<Integer>
   * @author 刘飞华
   * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 4)
   @Operation(summary = "1.4 更新字典类型状态")
   @PostMapping("/updateDictTypeStatus")
   @OperateLog(description = "【字典类型】更新字典类型状态")
  public Result<Integer> updateDictTypeStatus(@RequestBody @Valid UpdateDictTypeStatusReqVo dictType){
       return dictTypeService.updateDictTypeStatus(dictType);
  }

   /**
    * 查询字典类型详情
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 5)
   @Operation(summary = "1.5 查询字典类型详情")
   @PostMapping("/queryDictTypeDetail")
   @OperateLog(description = "【字典类型】查询字典类型详情")
   public Result<QueryDictTypeDetailRespVo> queryDictTypeDetail(@RequestBody @Valid QueryDictTypeDetailReqVo dictType){
       return dictTypeService.queryDictTypeDetail(dictType);
   }

   /**
    * 查询字典类型列表
    *
    * @param dictType 请求参数
    * @return DictTypeResp
    * @author 刘飞华
    * @date: 2025/01/15 15:09:35
    */
   @ApiOperationSupport(order = 6)
   @Operation(summary = "1.6 查询字典类型列表")
   @PostMapping("/queryDictTypeList")
   @OperateLog(description = "【字典类型】查询字典类型列表")
   public Result<ResultPage<QueryDictTypeListRespVo>> queryDictTypeList(@RequestBody @Valid QueryDictTypeListReqVo dictType){
        return dictTypeService.queryDictTypeList(dictType);
   }

}
